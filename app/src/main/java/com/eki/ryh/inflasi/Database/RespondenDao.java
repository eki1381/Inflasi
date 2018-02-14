package com.eki.ryh.inflasi.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.eki.ryh.inflasi.Model.Responden;

import java.util.List;

/**
 * Created by user on 12/02/2018.
 */
@Dao
public interface RespondenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertResponden(Responden responden);

    @Query("SELECT * FROM Responden")
    List<Responden> getAllResponden();
}
