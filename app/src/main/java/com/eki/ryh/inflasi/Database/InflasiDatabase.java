package com.eki.ryh.inflasi.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Model.Questionnaire;
import com.eki.ryh.inflasi.Model.Responden;
import com.huma.room_for_asset.RoomAsset;

/**
 * Created by user on 08/02/2018.
 */

@Database(entities = {Barang.class, Merek.class, Responden.class, Questionnaire.class}, version = 2)
public abstract class InflasiDatabase extends RoomDatabase {

    private static InflasiDatabase INSTANCE;

    public abstract BarangDao barangDao();

    public abstract MerekDao merekDao();

    public abstract RespondenDao respondenDao();

    public abstract QuestionnaireDao questionnaireDao();

    private static final Object sLock = new Object();

    public static InflasiDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = RoomAsset.databaseBuilder(context.getApplicationContext(),
                        InflasiDatabase.class, "Inflasi.db")
                        .build();
            }
            return INSTANCE;
        }
    }

}