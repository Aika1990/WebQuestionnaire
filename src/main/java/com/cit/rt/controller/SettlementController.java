package com.cit.rt.controller;

import com.cit.rt.controller.dto.SettlementDTO;
import com.cit.rt.entity.District;
import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.DistrictService;
import com.cit.rt.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/settlement")
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    @Autowired
    private DistrictService districtService;

    @GetMapping("/list")
    public String listSettlements(Model model) {
        List<SettlementDTO> settlementDTOs = new ArrayList<>();
        if(settlementService.getAllSettlements() != null) {
            for(Settlement settlement : settlementService.getAllSettlements()) {
                SettlementDTO settlementDTO = new SettlementDTO();
                settlementDTO.setId(settlement.getId());
                settlementDTO.setName(settlement.getName());
               // settlementDTO.setDistrict(settlement.getDistrict().getName());
                settlementDTOs.add(settlementDTO);
            }
        }
        model.addAttribute("settlementDTOs", settlementDTOs);
        return "list-settlements";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        model.addAttribute("settlementDTO", new SettlementDTO());
        model.addAttribute("edit", false);
        return "settlement-form";
    }


    @PostMapping("/saveSettlement")
    public String saveSettlement(@Valid Settlement settlement, BindingResult result, Model model) throws ResourceNotFoundException {

        if(result.hasErrors()) {
            return "settlement-form";
        }
        settlement.setDistrict(districtService.getDistrictById(Integer.parseInt(settlement.getDistrict().getName())));
        settlementService.saveSettlement(settlement);
        return "redirect:/settlement/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("settlementId") int id,
                                    Model model) throws ResourceNotFoundException {
        Settlement settlement = settlementService.getSettlementById(id);
        SettlementDTO settlementDTO = new SettlementDTO();
        settlementDTO.setId(settlement.getId());
        settlementDTO.setName(settlement.getName());
        //settlementDTO.setDistrict(settlement.getDistrict().getName(););
        model.addAttribute("settlementDTO", settlementDTO);
        model.addAttribute("edit", true);
        return "settlement-form";
    }

    @GetMapping("/delete")
    public String deleteSettlement(@RequestParam("settlementId") int id) throws ResourceNotFoundException{
        settlementService.deleteSettlementById(id);
        return "redirect:/settlement/list";
    }

    @ModelAttribute("districts")
    public List<District> initializeDistricts() {
        return districtService.getAllDistricts();
    }
}
