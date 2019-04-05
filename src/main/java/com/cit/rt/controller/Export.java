package com.cit.rt.controller;

import com.cit.rt.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Export {

    @Autowired
    DistrictService districtService;

    @RequestMapping(value = "/export/download", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("districts", districtService.getAllDistricts());
        return "";
    }
}
