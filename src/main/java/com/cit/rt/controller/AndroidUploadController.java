package com.cit.rt.controller;

import com.cit.rt.controller.dto.AppSettingsDTO;
import com.cit.rt.controller.dto.QuestionnaireDTO;
import com.cit.rt.controller.dto.QuestionnaireNumDTO;
import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.Questionnaire;
import com.cit.rt.entity.QuestionnaireNum;
import com.cit.rt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

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
            appSettings.setSettlement(settlementService.getSettlementById(2).getId());
            return appSettings;

        }catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "android/appSettings/save", method = RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public AppSettingsDTO save(@RequestBody AppSettingsDTO appSettingsDTO) {
        try {
            AppSettings appSettings = appSettingsService.saveAppSetting(new AppSettings(settlementService.getSettlementById(appSettingsDTO.getSettlement()),
                    appSettingsDTO.getLastName(), appSettingsDTO.getFirstName(), appSettingsDTO.getPhone()));
            AppSettingsDTO settingsDTO = new AppSettingsDTO();
            settingsDTO.setId(appSettings.getId());
            return settingsDTO;

        }catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "android/questionnaireNum/save", method = RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public QuestionnaireNumDTO save(@RequestBody QuestionnaireNumDTO questionnaireNumDTO) {
        try {
            QuestionnaireNum questionnaireNum = questionnaireNumService.saveQuestionnaireNum(new QuestionnaireNum(appSettingsService.getAppSettingsById(questionnaireNumDTO.appSettingsId)));
            return new QuestionnaireNumDTO(questionnaireNum.getId(), questionnaireNum.getAppSettings().getId());
        }catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "android/questionnaires/save", method = RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    @ResponseBody
    public void save(@RequestBody List<QuestionnaireDTO> questionnaireDTOs) {
        try {
            if(questionnaireDTOs.size() > 0) {
                for (QuestionnaireDTO questionnaireDTO : questionnaireDTOs) {
                    questionnaireService.saveQuestionnaire(new Questionnaire(questionnaireNumService.getQuestionnaireNumById(questionnaireDTO.getQuestionnaireNumId()),
                            answerService.getAnswerById(questionnaireDTO.getAnswerId()), questionnaireDTO.getDescriptionOther(),
                            questionnaireDTO.getIdParentAnswer()));
                }
            }
        }catch (Exception e) {

        }
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
