package com.cit.rt.controller;

import com.cit.rt.entity.*;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appSettings")
public class AppSettingsController {

    @Autowired
    private AppSettingsService appSettingsService;

    @Autowired
    SettlementService settlementService;

    @Autowired
    QuestionnaireNumService questionnaireNumService;

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionnaireService questionnaireService;

    @GetMapping("/list")
    public String listAppSettings(Model model) {
        List <AppSettings> appSettings = appSettingsService.getAllAppSettings();
        model.addAttribute("appSettings", appSettings);
        return "list-appSettings";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        AppSettings appSettings = new AppSettings();
        model.addAttribute("appSettings", appSettings);
        return "appSettings-form";
    }

    @PostMapping("/saveAppSettings")
    public String saveAppSettings(@ModelAttribute("appSettings") AppSettings appSettings) {
        appSettingsService.saveAppSettings(appSettings);
        return "redirect:/appSettings/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("appSettingsId") int id,
                                    Model model) throws ResourceNotFoundException {
        AppSettings appSettings = appSettingsService.getAppSettingsById(id);
        model.addAttribute("appSettings", appSettings);
        return "appSettings-form";
    }

    @GetMapping("/delete")
    public String deleteAppSettings(@RequestParam("appSettingsId") int id) throws ResourceNotFoundException{
        appSettingsService.deleteAppSettingsById(id);
        return "redirect:/appSettings/list";
    }

    @GetMapping("/addAppSettings")
    public String addAppSettings() throws ResourceNotFoundException {
//        appSettingsService.deleteAppSettingsById(416);
//        appSettingsService.deleteAppSettingsById(417);
//        appSettingsService.deleteAppSettingsById(418);
//        appSettingsService.deleteAppSettingsById(419);
        //appSettingsService.saveAppSettings(new AppSettings(settlementService.getSettlementById(19) , "Кожомбаева", "Айнура", "89232775457"));
        //questionnaireNumService.saveQuestionnaireNum(new QuestionnaireNum(appSettingsService.getAppSettingsById(420)));
        questionnaireService.saveQuestionnaire(new Questionnaire(questionnaireNumService.getQuestionnaireNumById(421), questionService.getQuestionById(145),
                null, "Баруун-Хемчикский район, с.Бай-Тал"));
        return "redirect:/appSettings/list";
    }

}
