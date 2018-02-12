package com.eki.ryh.inflasi.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.eki.ryh.inflasi.Model.Merek;

import java.util.List;

/**
 * Created by user on 09/02/2018.
 */
@Dao
public interface MerekDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMerek(Merek merek);

    @Query("SELECT * FROM Merek WHERE itemId = :itemId")
    List<Merek> getMerekByBarangId(String itemId);

    @Query("SELECT * FROM Merek")
    List<Merek> getAllMerek();
}
