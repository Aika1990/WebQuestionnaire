package com.cit.rt.repository;

import com.cit.rt.entity.Answer;
import com.cit.rt.entity.Question;
import com.cit.rt.entity.Questionnaire;
import com.cit.rt.entity.QuestionnaireNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {

    @Query("SELECT q from Questionnaire q where q.questionnaireNum = :id")
    List<Questionnaire> getQuestionnareByQnaireNum(QuestionnaireNum id);

    @Query("select q from Questionnaire q where q.question = :question")
    List<Questionnaire> getQuestionnaireByQuestionId(Question question);

    // @Query("SELECT qnaireNum FROM QuestionnaireNum qnaireNum join qnaireNum.appSettings app WHERE app.id = :app_settings_id")
    @Query("select q from Questionnaire q where q.answer = :answer")
    List<Questionnaire> getQuestionnaireByAnswerId(Answer answer);

    @Query("select q from Questionnaire q where q.descriptionOther = :settlementId")
    List<Questionnaire> getQuestionnaireByDescription(String settlementId);

//    @Query("SELECT count (q)" +
//            "FROM Questionnaire q" +
//            "INNER JOIN " +
//            "QuestionnaireNum qnum" +
//            "INNER JOIN " +
//            "AppSettings app" +
//            "INNER JOIN " +
//            "Settlement settl" +
//            "INNER JOIN " +
//            "District d " +
//            "ON " +
//            "q.questionnaire_num_id = qnum.id" +
//            "AND qnum.app_settings_id = app.id" +
//            "AND app.settlement_id = settl.id" +
//            "AND settl.district_id = d.id" +
//            "WHERE d.id = :districtId" +
//            "GROUP BY d.id")
//    long getCountLive(Integer districtId);

}
