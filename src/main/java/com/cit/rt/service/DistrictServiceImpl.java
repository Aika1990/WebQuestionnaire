package com.cit.rt.service;

import com.cit.rt.entity.District;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    @Transactional
    public List<District> getAllDistricts() {
        return (List<District>) districtRepository.findAll();
    }

    @Override
    @Transactional
    public District getDistrictById(Integer id) throws ResourceNotFoundException {

        return districtRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveDistrict(District district) {
        districtRepository.save(district);
    }

    @Override
    @Transactional
    public void deleteDistrictById(Integer id) {
        districtRepository.deleteById(id);
    }

    @Override
    @Transactional
    public District findByNameDistrict(String name) {
        return districtRepository.findByNameDistrict(name);
    }
}
