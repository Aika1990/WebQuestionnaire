package com.cit.rt.controller;

import com.cit.rt.entity.District;
import com.cit.rt.service.DistrictService;
import com.cit.rt.util.ExcelDistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ExcelDownloadRestAPI {

    @Autowired
    DistrictService districtService;

    @RequestMapping(value = "/export/download/districts.xlsx", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<District> districts = (List<District>) districtService.getAllDistricts();

        ByteArrayInputStream in = ExcelDistrict.districtsToExcel(districts);
        // return IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=districts.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}
