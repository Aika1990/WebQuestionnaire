package com.cit.rt.controller.dto;

import java.util.List;

public class QnaireNumWorkerDTO {

    public Integer idQnaireNum;
    public List<QuestionnaireStrDTO> questionnaireStrDTOs;

    public QnaireNumWorkerDTO() {
    }

    public QnaireNumWorkerDTO(Integer idQnaireNum, List<QuestionnaireStrDTO> questionnaireStrDTOs) {
        this.idQnaireNum = idQnaireNum;
        this.questionnaireStrDTOs = questionnaireStrDTOs;
    }

    public Integer getIdQnaireNum() {
        return idQnaireNum;
    }

    public void setIdQnaireNum(Integer idQnaireNum) {
        this.idQnaireNum = idQnaireNum;
    }

    public List<QuestionnaireStrDTO> getQuestionnaireStrDTOs() {
        return questionnaireStrDTOs;
    }

    public void setQuestionnaireStrDTOs(List<QuestionnaireStrDTO> questionnaireStrDTOs) {
        this.questionnaireStrDTOs = questionnaireStrDTOs;
    }
}
