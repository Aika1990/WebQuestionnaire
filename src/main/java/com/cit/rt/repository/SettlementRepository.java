package com.cit.rt.repository;

import com.cit.rt.entity.District;
import com.cit.rt.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SettlementRepository extends JpaRepository<Settlement, Integer> {

    @Query("SELECT sett FROM Settlement sett WHERE sett.district  = :district")
    List<Settlement> getSettlementByDistrictId(District district);
}
