package com.cit.rt.controller;

import com.cit.rt.entity.Question;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    public String listQuestions(Model model) {
        List <Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "list-questions";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "question-form";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") Question question) {
        questionService.saveQuestion(question);
        return "redirect:/question/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("questionId") int id,
                                    Model model) throws ResourceNotFoundException {
        Question question = questionService.getQuestionById(id);
        model.addAttribute("question", question);
        return "question-form";
    }

    @GetMapping("/delete")
    public String deleteQuestion(@RequestParam("questionId") int id) throws ResourceNotFoundException{
        questionService.deleteQuestionById(id);
        return "redirect:/question/list";
    }
}
