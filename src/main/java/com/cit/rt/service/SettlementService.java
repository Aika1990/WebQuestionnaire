package com.cit.rt.service;

import com.cit.rt.entity.District;
import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface SettlementService {

    List<Settlement> getAllSettlements();
    Settlement getSettlementById(Integer id) throws ResourceNotFoundException;
    void saveSettlement(Settlement settlement);
    void deleteSettlementById(Integer id) throws ResourceNotFoundException;
}