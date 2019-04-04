package com.cit.rt.controller;

import com.cit.rt.controller.dto.AnswerDTO;
import com.cit.rt.controller.dto.DistrictDTO;
import com.cit.rt.controller.dto.QuestionDTO;
import com.cit.rt.controller.dto.SettlementDTO;
import com.cit.rt.entity.Answer;
import com.cit.rt.entity.District;
import com.cit.rt.entity.Question;
import com.cit.rt.entity.Settlement;
import com.cit.rt.service.AnswerService;
import com.cit.rt.service.DistrictService;
import com.cit.rt.service.QuestionService;
import com.cit.rt.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AndroidSaveDataController {

    @Autowired
    DistrictService districtService;

    @Autowired
    SettlementService settlementService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "load/districts", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<DistrictDTO> loadDistricts() {
        try {
            List<District> districts = districtService.getAllDistricts();
            ArrayList<DistrictDTO> districtDTOs = new ArrayList<>();
            if(districts.size() > 0) {
                for(District district : districts) {
                    districtDTOs.add(new DistrictDTO(district.getId(), district.getName()));
                }
            }
            return districtDTOs;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "load/settlements", method = RequestMethod.GET)
    public ArrayList<SettlementDTO> loadSettlements() {
        try {
            List<Settlement> settlements = settlementService.getAllSettlements();
            ArrayList<SettlementDTO> settlementDTOs = new ArrayList<>();
            if(settlements.size() > 0) {
                for(Settlement settlement : settlements) {
                    settlementDTOs.add(new SettlementDTO(settlement.getId(), settlement.getName(), settlement.getDistrict().getId()));
                }
            }
            return settlementDTOs;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "load/questions", method = RequestMethod.GET)
    public ArrayList<QuestionDTO> loadQuestions() {
        try {
            List<Question> questions = questionService.getAllQuestions();
            ArrayList<QuestionDTO> questionDTOs = new ArrayList<>();
            if(questions.size() > 0) {
                for(Question question : questions) {
                    questionDTOs.add(new QuestionDTO(question.getId(), question.getName(), question.getTypeQuestion()));
                }
            }
            return questionDTOs;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "load/answers", method = RequestMethod.GET)
    public ArrayList<AnswerDTO> loadAnswers() {
        try {
            List<Answer> answers = answerService.getAllAnswers();
            ArrayList<AnswerDTO> answerDTOs = new ArrayList<>();
            if(answers.size() > 0) {
                for(Answer answer : answers) {
                    answerDTOs.add(new AnswerDTO(answer.getId(), answer.getName(), answer.getQuestion().getId()));
                }
            }
            return answerDTOs;
        } catch (Exception e) {
            return null;
        }
    }
}
