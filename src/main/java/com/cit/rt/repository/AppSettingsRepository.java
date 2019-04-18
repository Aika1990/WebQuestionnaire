package com.cit.rt.repository;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppSettingsRepository extends JpaRepository<AppSettings, Integer> {

    @Query("SELECT app FROM AppSettings app join app.settlement settl WHERE app.lastName = :lastName and app.firstName = :firstName and app.phone = :phone and settl.id = :settlement")
    AppSettings findByDetailsAppsettings(String lastName, String firstName, String phone, Integer settlement);

//    @Query("SELECT app FROM AppSettings app join app.settlement settl WHERE app.lastName = :lastName and app.firstName = :firstName and app.phone = :phone and settl.id = :settlement")
//    AppSettings findByDetailsAppsettings(String lastName, String firstName, String phone, Integer settlement);

    @Query("SELECT app FROM AppSettings app WHERE app.settlement = :settlement")
    List<AppSettings> getAppSettingsBySettlement(Settlement settlement);
}
