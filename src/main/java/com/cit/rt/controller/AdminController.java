package com.cit.rt.controller;

import com.cit.rt.controller.dto.*;
import com.cit.rt.entity.*;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DistrictService districtService;

    @Autowired
    AppSettingsService appSettingsService;

    @Autowired
    SettlementService settlementService;

    @Autowired
    QuestionnaireNumService questionnaireNumService;

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @GetMapping
    public String getAdmin(Model model) {
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        model.addAttribute("countSettlement", settlementService.getAllSettlements().size());
        model.addAttribute("countWorkers", appSettingsService.getAllAppSettings().size());
        model.addAttribute("countQnaireNum", questionnaireNumService.getAllQuestionnaireNums().size());
        return "admin";
    }

    @GetMapping("/workers")
    public String getWorkerList(Model model) {
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);

        List<AppSettings> appSettings = appSettingsService.getAllAppSettings();
        List<WorkerDTO> workerDTOs = new ArrayList<>();
        if (appSettings.size() > 0) {
            for (AppSettings settings : appSettings) {
                WorkerDTO workerDTO = new WorkerDTO();
                workerDTO.setLastName(settings.getLastName());
                workerDTO.setFirstName(settings.getFirstName());
                workerDTO.setPhone(settings.getPhone());
                Settlement settlement = settings.getSettlement();
//                District district = settlement.getDistrict();
                workerDTO.setSettlement(settlement.getDistrict().getName() + ", поселение: " + settlement.getName());//+  settings.getSettlement().getDistrict().getName()
                //List<QuestionnaireNum> questionnaireNums = questionnaireNumService.getQnaireByAppSettings(settings.getId()); //получаем номера опросов
                workerDTO.setCount(questionnaireNumService.getQnaireByAppSettings(settings.getId()).size());

                workerDTOs.add(workerDTO);
            }
        }
        model.addAttribute("workerDTOs", workerDTOs);
        return "list-app_settings";
    }

    @GetMapping("/list/workers")
    public String getWorkerList(@RequestParam("districtId") int id, Model model) throws ResourceNotFoundException {
        List<WorkersSettlementDTO> workersSettlementDTOList = new ArrayList<>();
        List<Settlement> settlements = settlementService.getSettlementByDistrictId(id); //получаем список поселений
        Integer countWorkers = 0;
        Integer countQnaireNum = 0;
        for (Settlement settlement : settlements) {
            Integer count = 0;
            List<AppSettings> appSettingsList = appSettingsService.getAppSettingsBySettlement(settlement); //получаем список настроек данного поселения
            List<WorkerDTO> workerDTOs = new ArrayList<>();
            if (appSettingsList.size() > 0) {
                for (AppSettings appSettings : appSettingsList) { //у каждой настройки работник
                    List<QuestionnaireNum> questionnaireNums = questionnaireNumService.getQnaireByAppSettings(appSettings.getId()); //получаем номера опросов
                    if (questionnaireNums.size() > 0) {
                        WorkerDTO workerDTO = new WorkerDTO();
                        workerDTO.setId(appSettings.getId());//if настройки
                        workerDTO.setFirstName(appSettings.getFirstName());
                        workerDTO.setLastName(appSettings.getLastName());
                        workerDTO.setPhone(appSettings.getPhone());
                        workerDTO.setCount(questionnaireNums.size());//кол-во опросов
                        workerDTOs.add(workerDTO);
                        count += questionnaireNums.size();
                        countQnaireNum += questionnaireNums.size();
                    }
                }
            }
            WorkersSettlementDTO workersSettlementDTO = new WorkersSettlementDTO();
            if (workerDTOs.size() > 0) {
                countWorkers++;
                workersSettlementDTO.setId(settlement.getId());
                workersSettlementDTO.setNameSettlement(settlement.getName());
                workersSettlementDTO.setQnaireNum(count);
                workersSettlementDTO.setWorkerDTOs(workerDTOs);
            } else {
                workersSettlementDTO.setNameSettlement(settlement.getName());
                workersSettlementDTO.setQnaireNum(0);
                workersSettlementDTO.setWorkerDTOs(null);
            }
            workersSettlementDTOList.add(workersSettlementDTO);
        }

        model.addAttribute("countSettlement", settlements.size());
        model.addAttribute("countWorkers", countWorkers);
        model.addAttribute("countQnaireNum", countQnaireNum);
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        model.addAttribute("workersSettlementDTOList", workersSettlementDTOList);
        return "admin";
    }

    @GetMapping("/district/workers")
    public String getDistrictWorker(@RequestParam("districtId") int id, Model model) throws ResourceNotFoundException {

        List<WorkerDTO> workerDTOs = new ArrayList<>();
        for (Settlement settlement : settlementService.getSettlementByDistrictId(id)) {
            List<AppSettings> appSettingsList = appSettingsService.getAppSettingsBySettlement(settlement); //получаем список настроек данного поселения
            if (appSettingsList.size() > 0) {
                for (AppSettings appSettings : appSettingsList) { //у каждой настройки работник
                    List<QuestionnaireNum> questionnaireNums = questionnaireNumService.getQnaireByAppSettings(appSettings.getId()); //получаем номера опросов
                    if (questionnaireNums.size() > 0) {
                        WorkerDTO workerDTO = new WorkerDTO();
                        workerDTO.setLastName(appSettings.getLastName());
                        workerDTO.setFirstName(appSettings.getFirstName());
                        workerDTO.setPhone(appSettings.getPhone());
                        workerDTO.setCount(questionnaireNums.size());//кол-во опросов
                        workerDTO.setSettlement(settlement.getDistrict().getName() + ", поселение: " + settlement.getName());
                        workerDTOs.add(workerDTO);
                    }
                }
            }
        }
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        model.addAttribute("workerDTOs", workerDTOs);
        return "list-app_settings";
    }

    @GetMapping("/questionnaire")
    public String getQuestionnaires(Model model) {

        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        model.addAttribute("countSettlement", settlementService.getAllSettlements().size());
        model.addAttribute("countWorkers", appSettingsService.getAllAppSettings().size());
        model.addAttribute("countQnaireNum", questionnaireNumService.getAllQuestionnaireNums().size());
        return "list-questionnaires";
    }

    @GetMapping("/district/questoinnaire")
    public String getDistrictQuestionnaires(@RequestParam("districtId") int id, Model model) throws ResourceNotFoundException {

        List<Questionnaire> questionnaireList = questionnaireService.getQuestionnaireByQuestionId(questionService.getQuestionById(148));//узнаем где место проживание
        List<Settlement> settlements = settlementService.getSettlementByDistrictId(id); //получаем список поселений данного района

        List<QuestionnaireWorkerDTO> questionnaireWorkerDTOs = new ArrayList<>();//список для работников проведенных опрос

        Integer count = 0;
        for (Settlement settlement : settlements) {
            if (questionnaireList.size() > 0) {
                List<Questionnaire> resultSettlement = questionnaireList.stream()
                        .filter(a -> Objects.equals(a.getDescriptionOther(), settlement.getId().toString()))
                        .collect(Collectors.toList());//опросы проведенные в данном поселении
                if (resultSettlement.size() > 0) {
                    List<AppSettings> appSettingsList = appSettingsService.getAppSettingsBySettlement(settlement); //получаем список настроек данного поселения
                    for (AppSettings appSettings : appSettingsList) {
                        QuestionnaireWorkerDTO questionnaireWorkerDTO = new QuestionnaireWorkerDTO(settlement.getName(), appSettings.getLastName(), appSettings.getFirstName(), appSettings.getPhone());

                        List<Questionnaire> result = resultSettlement.stream()
                                .filter(a -> Objects.equals(a.getQuestionnaireNum().getAppSettings().getId(), appSettings.getId()))
                                .collect(Collectors.toList()); //получили список опросов данного работника
                        if (result.size() > 0) {

                            questionnaireWorkerDTO.countQnaire = result.size();//кол-во опросов данного работника
                            count += result.size();

                            List<QnaireNumWorkerDTO> qnaireNumWorkerDTOs = new ArrayList<>();

                            for (Questionnaire q1 : result) {
                                List<Questionnaire> q = questionnaireService.getQuestionnareByQnaireNum(q1.getQuestionnaireNum());
                                List<QuestionnaireStrDTO> questionnaireStrDTOs = new ArrayList<>();//для хранения вопросоа и ответов опроса
                                for (Questionnaire questionnaire : q) {
                                    QuestionnaireStrDTO questionnaireStrDTO = new QuestionnaireStrDTO();
                                    questionnaireStrDTO.questionName = questionnaire.getQuestion().getName();
                                    if (!questionnaire.getDescriptionOther().isEmpty()) {
                                        questionnaireStrDTO.answerName = questionnaire.getDescriptionOther();
                                    } else {
                                        questionnaireStrDTO.answerName = questionnaire.getAnswer().getName();
                                    }
                                    questionnaireStrDTOs.add(questionnaireStrDTO);
                                }
                                if (questionnaireStrDTOs.size() > 0) {
                                    qnaireNumWorkerDTOs.add(new QnaireNumWorkerDTO(q1.getQuestionnaireNum().getId(), questionnaireStrDTOs));
                                    questionnaireWorkerDTO.qnaireNumWorkerDTOs = qnaireNumWorkerDTOs;
                                }
                                questionnaireList.remove(q1);
                            }
                            if (questionnaireWorkerDTO.qnaireNumWorkerDTOs.size() > 0) {
                                questionnaireWorkerDTOs.add(questionnaireWorkerDTO);
                            }
                        }
                    }
                }
            }
        }

        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        model.addAttribute("questionnaireWorkerDTOs", questionnaireWorkerDTOs);
        model.addAttribute("countSettlement", settlements.size());
        model.addAttribute("countQnaireNum", count);
        return "list-questionnaires";
    }

    @GetMapping("/questions")
    public String getQuestions(Model model) {

        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "list-questions";
    }

    @GetMapping("/question/answers")
    public String getQuestionsAnswer(@RequestParam("questionId") int id, Model model) throws ResourceNotFoundException {

        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);

        List<AnswerCountDTO> answerCountDTOs = new ArrayList<>();

        Question question = questionService.getQuestionById(id);
        List<Questionnaire> questionnaireList = questionnaireService.getQuestionnaireByQuestionId(question);

        if (question.getName().equals("Где проживает Ваша семья:")) {
            Double sum = 0.0;
            List<District> districts = districtService.getAllDistricts();
            for (District district : districts) {
                Integer count = 0;
                if (questionnaireList.size() > 0) {
                    List<Settlement> settlements = settlementService.getSettlementByDistrictId(district.getId());
                    for (Settlement settlement : settlements) {
                        List<Questionnaire> result = questionnaireList.stream()
                                .filter(a -> Objects.equals(a.getDescriptionOther(), settlement.getId().toString()))
                                .collect(Collectors.toList());
                        if (result.size() > 0) {
                            count += result.size();
                            sum += result.size();
                            for (Questionnaire q : result) {
                                questionnaireList.remove(q);
                            }
                        }
                    }
                }
                AnswerCountDTO answerCountDTO = new AnswerCountDTO(question.getId().toString(), district.getName(), count);
                answerCountDTOs.add(answerCountDTO);
            }
            answerCountDTOs = getPercent(answerCountDTOs, sum);
        } else if (question.getId() == 149) {

            Double sum = 0.0;
            List<Questionnaire> result = questionnaireList.stream()
                    .filter(a -> Objects.equals(a.getDescriptionOther(), "1"))
                    .collect(Collectors.toList());
            if (result.size() > 0) {
                sum += result.size();
                for (Questionnaire q : result) {
                    questionnaireList.remove(q);
                }
            }

            List<Questionnaire> result2 = questionnaireList.stream()
                    .filter(a -> Objects.equals(a.getDescriptionOther(), "2"))
                    .collect(Collectors.toList());

            if (result2.size() > 0) {
                sum += result2.size();
                for (Questionnaire q : result2) {
                    questionnaireList.remove(q);
                }
            }

            List<Questionnaire> result3 = questionnaireList.stream()
                    .filter(a -> Objects.equals(a.getDescriptionOther(), "3"))
                    .collect(Collectors.toList());

            if (result3.size() > 0) {
                sum += result3.size();
                for (Questionnaire q : result3) {
                    questionnaireList.remove(q);
                }
            }

            List<Questionnaire> result4 = questionnaireList.stream()
                    .filter(a -> Objects.equals(a.getDescriptionOther(), "4"))
                    .collect(Collectors.toList());

            if (result4.size() > 0) {
                sum += result4.size();
                for (Questionnaire q : result4) {
                    questionnaireList.remove(q);
                }
            }

            if (questionnaireList.size() > 0) {
                sum += questionnaireList.size();
            }
            answerCountDTOs.add(new AnswerCountDTO("149", "семья из 1 человека", result.size()));
            answerCountDTOs.add(new AnswerCountDTO("149", "семья из 2-x человек", result2.size()));
            answerCountDTOs.add(new AnswerCountDTO("149", "семья из 3-x человек", result3.size()));
            answerCountDTOs.add(new AnswerCountDTO("149", "семья из 4-x человек", result4.size()));
            answerCountDTOs.add(new AnswerCountDTO("149", "семья из 5-ти человек и более", questionnaireList.size()));

            answerCountDTOs = getPercent(answerCountDTOs, sum);

        } else if (question.getId() == 175) {
            Integer age1 = 0, age2 = 0, age3 = 0;
            Double sum = 0.0;
            for (Questionnaire q : questionnaireList) {
                if (Integer.parseInt(q.getDescriptionOther()) >= 0 & Integer.parseInt(q.getDescriptionOther()) <= 3) {
                    age1++;
                    sum++;
                } else if (Integer.parseInt(q.getDescriptionOther()) >= 4 & Integer.parseInt(q.getDescriptionOther()) <= 14) {
                    age2++;
                    sum++;
                } else if (Integer.parseInt(q.getDescriptionOther()) >= 15 & Integer.parseInt(q.getDescriptionOther()) <= 18) {
                    age3++;
                    sum++;
                }
            }
            answerCountDTOs.add(new AnswerCountDTO("175", "0-3 лет", age1));
            answerCountDTOs.add(new AnswerCountDTO("175", "4-14 лет", age2));
            answerCountDTOs.add(new AnswerCountDTO("175", "15-18 лет", age3));

            answerCountDTOs = getPercent(answerCountDTOs, sum);
        } else if (question.getId() == 276) {
            answerCountDTOs = getAnswerCount(question, questionnaireList, answerCountDTOs);
        } else if (question.getId() == 286) {
            answerCountDTOs = getAnswerCount(question, questionnaireList, answerCountDTOs);
        } else if (question.getId() == 294) {
            answerCountDTOs = getInconeORconsumption(question, questionnaireList, answerCountDTOs);
        } else if (question.getId() == 295) {
            answerCountDTOs = getAnswerCount(question, questionnaireList, answerCountDTOs);
        } else if (question.getId() == 306) {
            answerCountDTOs = getInconeORconsumption(question, questionnaireList, answerCountDTOs);
        } else if (question.getId() == 415) {
            answerCountDTOs = getAnswerCount(question, questionnaireList, answerCountDTOs);
        } else if (question.getId() == 441) {
            answerCountDTOs = getAnswerCount(question, questionnaireList, answerCountDTOs);
        } else {
            List<Answer> answers = answerService.getAnswersByQuestion(question);
            if (answers.size() > 0) {
                Double sum = 0.0;
                for (Answer answer : answers) {
                    List<Questionnaire> result = new ArrayList<>();
                    if (questionnaireList.size() > 0) {
                        result = questionnaireList.stream()
                                .filter(a -> Objects.equals(a.getAnswer().getName(), answer.getName()))
                                .collect(Collectors.toList());
                        if (result.size() > 0) {
                            sum += result.size();
                            for (Questionnaire q : result) {
                                questionnaireList.remove(q);
                            }
                        }
                    }
                    AnswerCountDTO answerCountDTO = new AnswerCountDTO(question.getId().toString(), answer.getName(), result.size());
                    answerCountDTOs.add(answerCountDTO);
                }
                answerCountDTOs = getPercent(answerCountDTOs, sum);
            }
        }
        model.addAttribute("question", question.getName());
        model.addAttribute("answerCountDTOs", answerCountDTOs);

        return "list-questions";
    }

    public List<AnswerCountDTO> getAnswerCount(Question question, List<Questionnaire> questionnaireList, List<AnswerCountDTO> answerCountDTOs) {
        List<Answer> answers = answerService.getAnswersByQuestion(question);
        if (answers.size() > 0) {
            Double sum = 0.0;
            for (Answer answer : answers) {
                Double many = 0.0;
                List<Questionnaire> result = new ArrayList<>();
                if (questionnaireList.size() > 0) {
                    result = questionnaireList.stream()
                            .filter(a -> Objects.equals(a.getAnswer().getName(), answer.getName()))
                            .collect(Collectors.toList());
                    if (result.size() > 0) {

                        for (Questionnaire q : result) {
                            if (!q.getDescriptionOther().isEmpty()) {
                                Double d = Double.parseDouble(q.getDescriptionOther());
                                sum += d;
                                many += d;
                            }
                            questionnaireList.remove(q);
                        }
                    }
                }
                AnswerCountDTO answerCountDTO = new AnswerCountDTO(question.getId().toString(), answer.getName(), many.intValue());
                answerCountDTOs.add(answerCountDTO);
            }
            answerCountDTOs = getPercent(answerCountDTOs, sum);
        }
        return answerCountDTOs;
    }

    public List<AnswerCountDTO> getInconeORconsumption(Question question, List<Questionnaire> questionnaireList, List<AnswerCountDTO> answerCountDTOs) {
        Integer income1 = 0, income2 = 0, income3 = 0, income4 = 0, income5 = 0;
        Double sum = 0.0;
        for (Questionnaire q : questionnaireList) {
            if (Integer.parseInt(q.getDescriptionOther()) <= 11000) {
                income1++;
                sum++;
            } else if (Integer.parseInt(q.getDescriptionOther()) >= 11001 & Integer.parseInt(q.getDescriptionOther()) <= 20000) {
                income2++;
                sum++;
            } else if (Integer.parseInt(q.getDescriptionOther()) >= 20001 & Integer.parseInt(q.getDescriptionOther()) <= 30000) {
                income3++;
                sum++;
            } else if (Integer.parseInt(q.getDescriptionOther()) >= 30001 & Integer.parseInt(q.getDescriptionOther()) <= 50000) {
                income4++;
                sum++;
            } else if(Integer.parseInt(q.getDescriptionOther()) >= 50001) {
                income5++;
                sum++;
            }

        }
        answerCountDTOs.add(new AnswerCountDTO(question.getId().toString(), "до 10,0 тыс.руб.", income1));
        answerCountDTOs.add(new AnswerCountDTO(question.getId().toString(), "от 11,0 до 20,0 тыс.руб.", income2));
        answerCountDTOs.add(new AnswerCountDTO(question.getId().toString(), "от 21,0 до 30,0 тыс.руб.", income3));
        answerCountDTOs.add(new AnswerCountDTO(question.getId().toString(), "от 31,0 до 50,0 тыс.руб.", income4));
        answerCountDTOs.add(new AnswerCountDTO(question.getId().toString(), "от 51,0 тыс.руб.", income5));

        answerCountDTOs = getPercent(answerCountDTOs, sum);

        return answerCountDTOs;
    }


    public List<AnswerCountDTO> getPercent(List<AnswerCountDTO> answerCountDTOs, Double sum) {
        for (AnswerCountDTO answerCountDTO : answerCountDTOs) {
            if (answerCountDTO.countAnswer == 0 | sum == 0.0) {
                answerCountDTO.percent = "0.0";
            } else {
                answerCountDTO.percent = String.format("%.2f", (answerCountDTO.countAnswer / sum) * 100);
            }
        }
        return answerCountDTOs;
    }


}
