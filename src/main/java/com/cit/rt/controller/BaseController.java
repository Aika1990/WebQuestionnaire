package com.cit.rt.controller;

import com.cit.rt.controller.dto.TableDTO;

import java.util.ArrayList;
import java.util.Map;

public abstract class BaseController {

    public BaseController() {
    }

    protected void sidebarMenu(Map<String, Object> model) {
        ArrayList<TableDTO> tableDTOs = new ArrayList<TableDTO>();
        tableDTOs.add(new TableDTO("appSettings", "Настройки"));
        tableDTOs.add(new TableDTO("allDistricts", "Районы"));
        tableDTOs.add(new TableDTO("settlement", "Поселения"));
        tableDTOs.add(new TableDTO("question", "Вопросы"));
        tableDTOs.add(new TableDTO("questionnaire_numb", "Номер опроса"));
        tableDTOs.add(new TableDTO("answer", "Ответы"));
        tableDTOs.add(new TableDTO("questionnaire", "Опрос"));
        model.put("tableDTOs", tableDTOs);
    }
}
