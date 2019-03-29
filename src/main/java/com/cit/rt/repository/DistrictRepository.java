package com.cit.rt.repository;

import com.cit.rt.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DistrictRepository extends JpaRepository<District, Integer> {

    @Query("SELECT d FROM District d WHERE d.name = :name")
    District findByNameDistrict(String name);
}
