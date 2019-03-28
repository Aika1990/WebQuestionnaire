package com.cit.rt.controller;

import com.cit.rt.entity.Questionnaire;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/list")
    public String listQuestionnaires(Model model) {
        List <Questionnaire> questionnaires = questionnaireService.getAllQuestionnaires();
        model.addAttribute("questionnaires", questionnaires);
        return "list-questionnaires";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Questionnaire questionnaire = new Questionnaire();
        model.addAttribute("questionnaire", questionnaire);
        return "questionnaire-form";
    }

    @PostMapping("/saveQuestionnaire")
    public String saveQuestionnaire(@ModelAttribute("questionnaire") Questionnaire questionnaire) {
        questionnaireService.saveQuestionnaire(questionnaire);
        return "redirect:/questionnaire/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("questionnaireId") int id,
                                    Model model) throws ResourceNotFoundException {
        Questionnaire questionnaire = questionnaireService.getQuestionnaireById(id);
        model.addAttribute("questionnaire", questionnaire);
        return "questionnaire-form";
    }

    @GetMapping("/delete")
    public String deleteQuestionnaire(@RequestParam("questionnaireId") int id) throws ResourceNotFoundException{
        questionnaireService.deleteQuestionnaireById(id);
        return "redirect:/questionnaire/list";
    }
}
