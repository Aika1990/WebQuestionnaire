package com.cit.rt.service;

import com.cit.rt.controller.dto.AppSettingsDTO;
import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface AppSettingsService {

    public List<AppSettings> getAllAppSettings();
    public AppSettings getAppSettingsById(Integer id) throws ResourceNotFoundException;
    public void saveAppSettings(AppSettings appSettings);
    public void deleteAppSettingsById(Integer id) throws ResourceNotFoundException;
    AppSettings saveAppSetting(AppSettings appSettings);
    void deleteAllAppSettings();
    AppSettings findByDetailsAppsettings(String lastName, String firstName, String phone, Integer settlement);
    List<AppSettings> getAppSettingsBySettlement(Settlement settlement);
}
