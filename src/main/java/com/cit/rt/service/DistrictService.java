package com.cit.rt.service;

import com.cit.rt.entity.District;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface DistrictService {

    List<District> getAllDistricts();
    void saveDistrict(District district);
    District getDistrictById(Integer id) throws ResourceNotFoundException;
    void deleteDistrictById(Integer id) throws ResourceNotFoundException;
    District findByNameDistrict(String name);
}
