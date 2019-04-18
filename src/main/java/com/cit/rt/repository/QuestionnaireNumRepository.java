package com.cit.rt.repository;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.QuestionnaireNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface QuestionnaireNumRepository extends JpaRepository<QuestionnaireNum, Integer> {

    @Query("SELECT qnaireNum FROM QuestionnaireNum qnaireNum join qnaireNum.appSettings app WHERE app.id = :app_settings_id")
    List<QuestionnaireNum> getQnaireByAppSettings(@Param("app_settings_id") Integer app_settings_id);

    @Query("SELECT qnaireNum FROM QuestionnaireNum qnaireNum join qnaireNum.appSettings app WHERE app.id = :app_settings_id AND qnaireNum.createDate = :create_date")
    QuestionnaireNum getQuestionnaireNumByAppAndDate(@Param("app_settings_id") Integer app_settings_id, @Param("create_date")  String create_date);
}
