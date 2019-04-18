package com.cit.rt.controller;

import com.cit.rt.controller.dto.WorkerDTO;
import com.cit.rt.controller.dto.WorkersSettlementDTO;
import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.District;
import com.cit.rt.entity.QuestionnaireNum;
import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.AppSettingsService;
import com.cit.rt.service.DistrictService;
import com.cit.rt.service.QuestionnaireNumService;
import com.cit.rt.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DistrictService districtService;

    @Autowired
    AppSettingsService appSettingsService;

    @Autowired
    SettlementService settlementService;

    @Autowired
    QuestionnaireNumService questionnaireNumService;

    @GetMapping
    public String getAdmin(Model model) {
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        return "admin";
    }

    @GetMapping("/workers")
    public String getWorkerList(Model model) {
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);

        List<AppSettings> appSettings = appSettingsService.getAllAppSettings();
        List<WorkerDTO> workerDTOs = new ArrayList<>();
        if(appSettings.size() > 0) {
            for(AppSettings settings : appSettings) {
                WorkerDTO workerDTO = new WorkerDTO();
                workerDTO.setLastName(settings.getLastName());
                workerDTO.setFirstName(settings.getFirstName());
                workerDTO.setPhone(settings.getPhone());
                Settlement settlement = settings.getSettlement();
                //workerDTO.setSettlement(settlement.getDistrict().getName() + ", поселение: "+settlement.getName());//+  settings.getSettlement().getDistrict().getName()
                //List<QuestionnaireNum> questionnaireNums = questionnaireNumService.getQnaireByAppSettings(settings.getId()); //получаем номера опросов
                workerDTO.setCount(questionnaireNumService.getQnaireByAppSettings(settings.getId()).size());

                workerDTOs.add(workerDTO);
            }
        }
        model.addAttribute("workerDTOs", workerDTOs);
        return "list-app_settings";
    }

    @GetMapping("/list/workers")
    public String getWorkers(@RequestParam("districtId") int id, Model model) throws ResourceNotFoundException {
        List<WorkersSettlementDTO> workersSettlementDTOList = new ArrayList<>();
        List<Settlement> settlements = settlementService.getSettlementByDistrictId(id); //получаем список поселений
        Integer count = 0;
        for(Settlement settlement : settlements) {
            List<AppSettings> appSettingsList = appSettingsService.getAppSettingsBySettlement(settlement); //получаем список настроек данного поселения
            List<WorkerDTO> workerDTOs = new ArrayList<>();
            if(appSettingsList.size() > 0) {
                for (AppSettings appSettings : appSettingsList) { //у каждой настройки работник
                    List<QuestionnaireNum> questionnaireNums = questionnaireNumService.getQnaireByAppSettings(appSettings.getId()); //получаем номера опросов
                    if(questionnaireNums.size() > 0) {
                        WorkerDTO workerDTO = new WorkerDTO();
                        workerDTO.setId(appSettings.getId());//if настройки
                        workerDTO.setFirstName(appSettings.getFirstName());
                        workerDTO.setLastName(appSettings.getLastName());
                        workerDTO.setPhone(appSettings.getPhone());
                        workerDTO.setCount(questionnaireNums.size());//кол-во опросов
                        workerDTOs.add(workerDTO);
                        count += questionnaireNums.size();
                    }
                }
            }
            WorkersSettlementDTO workersSettlementDTO = new WorkersSettlementDTO();
            if(workerDTOs.size() > 0) {
                workersSettlementDTO.setId(settlement.getId());
                workersSettlementDTO.setNameSettlement(settlement.getName());
                workersSettlementDTO.setQnaireNum(count);
                workersSettlementDTO.setWorkerDTOs(workerDTOs);
            } else {
                workersSettlementDTO.setNameSettlement(settlement.getName());
                workersSettlementDTO.setQnaireNum(0);
                workersSettlementDTO.setWorkerDTOs(null);
            }
            workersSettlementDTOList.add(workersSettlementDTO);
        }
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        model.addAttribute("workersSettlementDTOList", workersSettlementDTOList);
        return "admin";
    }

    @GetMapping("/district/workers")
    public String getQuestionnaires() {

        return "list-questionnaires";
    }

    @GetMapping("/questionnaireNumbs/list")
    public String getQuestionnaireNumbs() {

        return "list_questionnaire_numbs";
    }


}
