package com.cit.rt.controller;

import com.cit.rt.entity.QuestionnaireNum;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.QuestionnaireNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questionnaireNum")
public class QuestionnaireNumController {

    @Autowired
    private QuestionnaireNumService questionnaireNumService;

    @GetMapping("/list")
    public String listQuestionnaireNums(Model model) {
        List <QuestionnaireNum> questionnaireNums = questionnaireNumService.getAllQuestionnaireNums();
        model.addAttribute("questionnaireNums", questionnaireNums);
        return "list_questionnaire_numbs";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        QuestionnaireNum questionnaireNum = new QuestionnaireNum();
        model.addAttribute("questionnaireNum", questionnaireNum);
        return "questionnaire_numbs-form";
    }

    @PostMapping("/saveQuestionnaireNum")
    public String saveQuestionnaireNum(@ModelAttribute("questionnaireNum") QuestionnaireNum questionnaireNum) {
        questionnaireNumService.saveQuestionnaireNum(questionnaireNum);
        return "redirect:/questionnaireNum/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("questionnaireNumId") int id,
                                    Model model) throws ResourceNotFoundException {
        QuestionnaireNum questionnaireNum = questionnaireNumService.getQuestionnaireNumById(id);
        model.addAttribute("questionnaireNum", questionnaireNum);
        return "questionnaire_numbs-form";
    }

    @GetMapping("/delete")
    public String deleteQuestionnaireNum(@RequestParam("questionnaireNumId") int id) throws ResourceNotFoundException{
        questionnaireNumService.deleteQuestionnaireNumById(id);
        return "redirect:/questionnaireNum/list";
    }
}
