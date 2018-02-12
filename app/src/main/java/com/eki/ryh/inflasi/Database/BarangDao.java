package com.eki.ryh.inflasi.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.eki.ryh.inflasi.Model.Barang;

import java.util.List;

/**
 * Created by user on 08/02/2018.
 */

@Dao
public interface BarangDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBarang(Barang brg);

    @Query("SELECT * FROM Barang")
    List<Barang> getAllBarang();

    @Query("SELECT * FROM Barang WHERE itemName = :itemName")
    List<Barang> getItemIdByItemName(String itemName);
}