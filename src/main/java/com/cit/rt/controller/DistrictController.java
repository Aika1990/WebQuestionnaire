package com.cit.rt.controller;

import com.cit.rt.entity.District;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/list")
    public String listDistricts(Model model) {
        List <District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        return "list-districts";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        District district = new District();
        model.addAttribute("district", district);
        return "district-form";
    }

    @PostMapping("/saveDistrict")
    public String saveDistrict(@ModelAttribute("district") District district) {
        districtService.saveDistrict(district);
        return "redirect:/district/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("districtId") int id,
                                    Model model) throws ResourceNotFoundException {
        District district = districtService.getDistrictById(id);
        model.addAttribute("district", district);
        return "district-form";
    }

    @GetMapping("/delete")
    public String deleteDistrict(@RequestParam("districtId") int id) throws ResourceNotFoundException{
        districtService.deleteDistrictById(id);
        return "redirect:/district/list";
    }
}
