package com.cit.rt.service;

import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.DistrictRepository;
import com.cit.rt.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    SettlementRepository settlementRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    @Transactional
    public List<Settlement> getAllSettlements() {
        return settlementRepository.findAll();
    }

    @Override
    @Transactional
    public Settlement getSettlementById(Integer id) throws ResourceNotFoundException {
        return settlementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveSettlement(Settlement settlement) {
        settlementRepository.save(settlement);
    }

    @Override
    public Settlement settlementSave(Settlement settlement) {
        return settlementRepository.save(settlement);
    }

    @Override
    @Transactional
    public void deleteSettlementById(Integer id) {
        settlementRepository.deleteById(id);
    }

    @Override
    public List<Settlement> getSettlementByDistrictId(Integer districtId) {
        return settlementRepository.getSettlementByDistrictId(districtRepository.getOne(districtId));
    }
}
