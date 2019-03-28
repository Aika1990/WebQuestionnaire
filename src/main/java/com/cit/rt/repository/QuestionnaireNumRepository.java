package com.cit.rt.repository;

import com.cit.rt.entity.QuestionnaireNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireNumRepository extends JpaRepository<QuestionnaireNum, Integer> {
}
