package com.cit.rt.controller;

import com.cit.rt.entity.Answer;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/list")
    public String listAnswers(Model model) {
        List <Answer> answers = answerService.getAllAnswers();
        model.addAttribute("answers", answers);
        return "list-answers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        return "answer-form";
    }

    @PostMapping("/saveAnswer")
    public String saveDistrict(@ModelAttribute("answer") Answer answer) {
        answerService.saveAnswer(answer);
        return "redirect:/answer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("answerId") int id,
                                    Model model) throws ResourceNotFoundException {
        Answer answer = answerService.getAnswerById(id);
        model.addAttribute("answer", answer);
        return "answer-form";
    }

    @GetMapping("/delete")
    public String deleteDistrict(@RequestParam("answerId") int id) throws ResourceNotFoundException{
        answerService.deleteAnswerById(id);
        return "redirect:/answer/list";
    }
}
