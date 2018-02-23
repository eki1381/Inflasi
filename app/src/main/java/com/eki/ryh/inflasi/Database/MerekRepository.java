package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by user on 09/02/2018.
 */

public class MerekRepository implements MerekDataSource {

    private static MerekRepository INSTANCE = null;

    private final MerekDataSource mMerekLocalDataSource;

    private MerekRepository(@NonNull MerekDataSource merekLocalDataSource) {
        mMerekLocalDataSource = checkNotNull(merekLocalDataSource);
    }

    public static MerekRepository getInstance(MerekDataSource merekLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new MerekRepository(merekLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void saveMerek(Merek merek) {
        checkNotNull(merek);
        mMerekLocalDataSource.saveMerek(merek);
    }

    @Override
    public void getAllMerek(@NonNull final LoadAllMerekCallback callback) {
        checkNotNull(callback);
        mMerekLocalDataSource.getAllMerek(new LoadAllMerekCallback() {
            @Override
            public void onAllMerekLoaded(List<Merek> mereks) {
                callback.onAllMerekLoaded(mereks);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getMerekByBarangId(int itemId, @NonNull final LoadMerekCallback callback) {
        checkNotNull(callback);
        mMerekLocalDataSource.getMerekByBarangId(itemId, new LoadMerekCallback() {
            @Override
            public void onMerekLoaded(List<Merek> mereks) {
                callback.onMerekLoaded(mereks);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
