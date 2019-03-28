package com.cit.rt.service;

import com.cit.rt.entity.District;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface DistrictService {

    public List<District> getAllDistricts();
    public void saveDistrict(District district);
    public District getDistrictById(Integer id) throws ResourceNotFoundException;
    public void deleteDistrictById(Integer id) throws ResourceNotFoundException;
}
