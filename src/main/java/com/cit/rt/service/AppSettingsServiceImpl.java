package com.cit.rt.service;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.AppSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppSettingsServiceImpl implements AppSettingsService {

    @Autowired
    private AppSettingsRepository appSettingsRepository;

    @Override
    @Transactional
    public List<AppSettings> getAllAppSettings() {
        return appSettingsRepository.findAll();
    }

    @Override
    @Transactional
    public AppSettings getAppSettingsById(Integer id) throws ResourceNotFoundException {
        return appSettingsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveAppSettings(AppSettings appSettings) {
        appSettingsRepository.save(appSettings);
    }

    @Override
    @Transactional
    public void deleteAppSettingsById(Integer id) {
        appSettingsRepository.deleteById(id);
    }
}
