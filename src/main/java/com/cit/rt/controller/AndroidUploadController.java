package com.cit.rt.controller;

import com.cit.rt.controller.dto.AppSettingsDTO;
import com.cit.rt.controller.dto.QuestionnaireDTO;
import com.cit.rt.controller.dto.QuestionnaireNumDTO;
import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.Questionnaire;
import com.cit.rt.entity.QuestionnaireNum;
import com.cit.rt.entity.Settlement;
import com.cit.rt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
class AndroidUploadController {

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

    @RequestMapping(value = "android/appSettings/find/{id}", method = RequestMethod.GET, produces = {
            MimeTypeUtils.APPLICATION_JSON_VALUE
    })
    public AppSettingsDTO find(@PathVariable("id") Integer id) {
        try {
            AppSettingsDTO appSettings = new AppSettingsDTO();
            appSettings.setId(id);
            appSettings.setLastName("Кожомбаева");
            appSettings.setFirstName("Айнура");
            appSettings.setPhone("89232775457");
            appSettings.setSettlementId(54);
            return appSettings;

        }catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "android/clearAll", method = RequestMethod.GET, produces = {
            MimeTypeUtils.APPLICATION_JSON_VALUE
    })
    public void clearAll() {
        questionnaireService.deleteAllQuestionnaire();
        questionnaireNumService.deleteAllQuestionnaireNum();
        appSettingsService.deleteAllAppSettings();
    }

    @RequestMapping(value = "android/appSettings/save", method = RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public AppSettingsDTO save(@RequestBody AppSettingsDTO appSettingsDTO) {
        try {
            AppSettings appSettings = appSettingsService.findByDetailsAppsettings(appSettingsDTO.lastName, appSettingsDTO.firstName, appSettingsDTO.phone, appSettingsDTO.settlementId);
            if(appSettings != null) {
                AppSettingsDTO settingsDTO = new AppSettingsDTO();
                settingsDTO.setId(appSettings.getId());
                return settingsDTO;
            } else {
                appSettings = appSettingsService.saveAppSetting(new AppSettings(settlementService.getSettlementById(appSettingsDTO.settlementId),
                        appSettingsDTO.getLastName(), appSettingsDTO.getFirstName(), appSettingsDTO.getPhone()));
                AppSettingsDTO settingsDTO = new AppSettingsDTO();
                settingsDTO.setId(appSettings.getId());
                return settingsDTO;
            }
        }catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "android/questionnaireNum/save", method = RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public QuestionnaireNumDTO save(@RequestBody QuestionnaireNumDTO questionnaireNumDTO) {
        try {
            QuestionnaireNum questionnaireNum = questionnaireNumService.getQuestionnaireNumByAppAndDate(questionnaireNumDTO.appSettingsId, questionnaireNumDTO.createDate);
            if (questionnaireNum != null) {
                return new QuestionnaireNumDTO(1, 1, String.valueOf(System.currentTimeMillis()));
            } else {
                questionnaireNum = questionnaireNumService.saveQuestionnaireNum(new QuestionnaireNum(appSettingsService.getAppSettingsById(questionnaireNumDTO.appSettingsId), questionnaireNumDTO.createDate));
                return new QuestionnaireNumDTO(questionnaireNum.getId(), questionnaireNum.getAppSettings().getId(), questionnaireNum.getCreateDate());
            }

        }catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "android/questionnaires/save", method = RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public List<QuestionnaireDTO> save(@RequestBody List<QuestionnaireDTO> questionnaireDTOs) {
        try {
            if(questionnaireDTOs.size() > 0) {
                for (QuestionnaireDTO questionnaireDTO : questionnaireDTOs) {
                    if(questionnaireDTO.answerId == null) {
                        questionnaireService.saveQuestionnaire(new Questionnaire(questionnaireNumService.getQuestionnaireNumById(questionnaireDTO.getQuestionnaireNumId()),
                                questionService.getQuestionById(questionnaireDTO.getQuestionId()), null, questionnaireDTO.getDescriptionOther()));
                    } else {
                        questionnaireService.saveQuestionnaire(new Questionnaire(questionnaireNumService.getQuestionnaireNumById(questionnaireDTO.getQuestionnaireNumId()),
                                questionService.getQuestionById(questionnaireDTO.getQuestionId()), answerService.getAnswerById(Integer.parseInt(questionnaireDTO.getAnswerId())), questionnaireDTO.getDescriptionOther()));
                    }

                }
                return questionnaireDTOs;
            }
        }catch (Exception e) {
            System.out.print(e.getMessage());
            //return null;
        }
        return null;
    }

//    private static String UPLOAD_DIR = "uploads";
//
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public String upload(@RequestParam("uploaded_file")MultipartFile file, HttpServletRequest request) {
//
//        try {
//            String fileName = file.getOriginalFilename();
//            String path = request.getServletContext().getRealPath("")
//                    + UPLOAD_DIR + File.separator + fileName;
//            saveFile(file.getInputStream(), path);
//            return fileName;
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//
//    }
//
//    private void saveFile(InputStream inputStream, String path) {
//        try {
//            OutputStream outputStream = new FileOutputStream(new File(path));
//            int read = 0;
//            byte[] bytes = new byte[1024];
//            while ((read = inputStream.read(bytes)) != -1) {
//                outputStream.write(bytes, 0, read);
//            }
//            outputStream.flush();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @RequestMapping(value = "/appSettings", method = RequestMethod.POST)
    public AppSettings createAppSettings(@RequestBody AppSettings appSettings) {
        return appSettingsService.saveAppSetting(appSettings);
    }
}
