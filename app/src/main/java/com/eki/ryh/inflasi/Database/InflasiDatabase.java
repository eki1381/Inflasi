package com.eki.ryh.inflasi.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;

/**
 * Created by user on 08/02/2018.
 */

@Database(entities = {Barang.class, Merek.class}, version = 1)
public abstract class InflasiDatabase extends RoomDatabase {

    private static InflasiDatabase INSTANCE;

    public abstract BarangDao barangDao();

    public abstract MerekDao merekDao();

    private static final Object sLock = new Object();

    public static InflasiDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        InflasiDatabase.class, "Inflasi.db")
                        .build();
            }
            return INSTANCE;
        }
    }

}