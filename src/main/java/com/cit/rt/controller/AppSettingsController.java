package com.cit.rt.controller;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.AppSettingsService;
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
}
