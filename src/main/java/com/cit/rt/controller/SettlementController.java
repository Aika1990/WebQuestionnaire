package com.cit.rt.controller;

import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.DistrictService;
import com.cit.rt.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Settlement> settlements = settlementService.getAllSettlements();
        model.addAttribute("settlements", settlements);
        return "list-settlements";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Settlement settlement = new Settlement();
        model.addAttribute("settlement", settlement);
        return "settlement-form";
    }

    @PostMapping("/saveSettlement")
    public String saveSettlement(@ModelAttribute("settlement") Settlement settlement) {

        settlementService.saveSettlement(settlement);
        return "redirect:/settlement/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("settlementId") int id,
                                    Model model) throws ResourceNotFoundException {
        Settlement settlement = settlementService.getSettlementById(id);
        model.addAttribute("settlement", settlement);
        return "settlement-form";
    }

    @GetMapping("/delete")
    public String deleteSettlement(@RequestParam("districtId") int id) throws ResourceNotFoundException{
        settlementService.deleteSettlementById(id);
        return "redirect:/settlement/list";
    }
}
