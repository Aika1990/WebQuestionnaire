package com.cit.rt.service;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface AppSettingsService {

    public List<AppSettings> getAllAppSettings();
    public AppSettings getAppSettingsById(Integer id) throws ResourceNotFoundException;
    public void saveAppSettings(AppSettings appSettings);
    public void deleteAppSettingsById(Integer id) throws ResourceNotFoundException;
}
