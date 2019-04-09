package com.cit.rt.repository;

import com.cit.rt.entity.AppSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppSettingsRepository extends JpaRepository<AppSettings, Integer> {

    @Query("SELECT app FROM AppSettings app WHERE app.lastName = :lastName and app.firstName = :firstName and app.phone = :phone")
    AppSettings findByDetailsAppsettings(String lastName, String firstName, String phone);
}
