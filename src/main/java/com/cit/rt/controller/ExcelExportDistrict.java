package com.cit.rt.controller;

import com.cit.rt.controller.dto.AnswerCountDTO;
import com.cit.rt.entity.*;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/export")
public class ExcelExportDistrict {

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


    @GetMapping("/questionnaireSettlement")
    public void exportExcel() throws IOException, ResourceNotFoundException {
        List<District> districts = districtService.getAllDistricts();
        for (District district : districts) {
            Workbook workbook = new XSSFWorkbook();
            List<AnswerCountDTO> answerCountDTOs = new ArrayList<>();
            List<Question> questions = questionService.getAllQuestions();
            Sheet sheet;
            try {
                for (Question question : questions) {
                    int rownum = 0;
                    String str = question.getName();
                    str = str.replaceAll("[,.:?]", "");
                    sheet = workbook.createSheet(str);
                    answerCountDTOs.clear();
                    List<Questionnaire> questionnaireList = questionnaireService.getQuestionnaireByQuestionId(question).stream()
                            .filter(a -> Objects.equals(a.getQuestionnaireNum().getAppSettings().getSettlement().getDistrict().getName(), district.getName()))
                            .collect(Collectors.toList());

                    if (questionnaireList.size() == 0) {
                        continue;
                    }
                    if (question.getName().equals("Где проживает Ваша семья:")) {
                        Double sum = 0.0;
                        Integer count = 0;
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
                            AnswerCountDTO answerCountDTO = new AnswerCountDTO(question.getId().toString(), settlement.getName(), count);
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

                    sheet.setColumnWidth(0, 10000);
                    sheet.setColumnWidth(1, 4000);
                    sheet.setColumnWidth(2, 4000);

                    Row rowTitle = sheet.createRow(rownum);
                    Cell c = rowTitle.createCell(0);
                    c.setCellValue(question.getName());
                    sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 6));

                    rownum++;
                    Row header = sheet.createRow(rownum);

                    CellStyle headerStyle = workbook.createCellStyle();

                    headerStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
                    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                    XSSFFont font = ((XSSFWorkbook) workbook).createFont();
                    font.setFontName("Arial");
                    font.setFontHeightInPoints((short) 12);
                    font.setBold(true);
                    headerStyle.setFont(font);

                    Cell headerCell = header.createCell(0);
                    headerCell.setCellValue("Наименование");
                    headerCell.setCellStyle(headerStyle);

                    headerCell = header.createCell(1);
                    headerCell.setCellValue("Количество");
                    headerCell.setCellStyle(headerStyle);

                    headerCell = header.createCell(2);
                    headerCell.setCellValue("Процент");
                    headerCell.setCellStyle(headerStyle);

                    CellStyle style = workbook.createCellStyle();
                    style.setWrapText(true);

                    CellStyle stylePer = workbook.createCellStyle();
                    stylePer.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));

                    Row row;
                    for (AnswerCountDTO a : answerCountDTOs) {
                        rownum++;
                        row = sheet.createRow(rownum);

                        Cell cell = row.createCell(0);
                        cell.setCellValue(a.answerName);
                        cell.setCellStyle(style);

                        cell = row.createCell(1);
                        cell.setCellValue(a.countAnswer);

                        cell = row.createCell(2);
                        cell.setCellValue(a.percent);
                        cell.setCellStyle(stylePer);
                    }
                }
                File currDir = new File("C:/Users/User/Documents/questionnaire/");
                String path = currDir.getAbsolutePath();
                String fileLocation = path + "/" +district.getName()+ ".xlsx";

                FileOutputStream outputStream = new FileOutputStream(fileLocation);
                workbook.write(outputStream);
            } finally {
                if (workbook != null) {
                    workbook.close();
                }
            }
        }

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
            } else if (Integer.parseInt(q.getDescriptionOther()) >= 50001) {
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
}
