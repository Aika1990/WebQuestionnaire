package com.cit.rt.service;

import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface SettlementService {

    List<Settlement> getAllSettlements();
    Settlement getSettlementById(Integer id) throws ResourceNotFoundException;
    void saveSettlement(Settlement settlement);
    Settlement settlementSave(Settlement settlement);
    void deleteSettlementById(Integer id) throws ResourceNotFoundException;
    List<Settlement> getSettlementByDistrictId(Integer districtId) throws ResourceNotFoundException;
}
