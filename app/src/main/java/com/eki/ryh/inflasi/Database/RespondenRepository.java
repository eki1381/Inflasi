package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Model.Responden;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by user on 12/02/2018.
 */

public class RespondenRepository implements RespondenDataSource {

    private static RespondenRepository INSTANCE = null;

    private final RespondenDataSource mRespondenLocalDataSource;

    private RespondenRepository(@NonNull RespondenDataSource respondenLocalDataSource) {
        mRespondenLocalDataSource = checkNotNull(respondenLocalDataSource);
    }

    public static RespondenRepository getInstance(RespondenDataSource respondenLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new RespondenRepository(respondenLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getAllResponden(@NonNull final LoadRespondenCallback callback) {
        checkNotNull(callback);

        mRespondenLocalDataSource.getAllResponden(new LoadRespondenCallback() {
            @Override
            public void onRespondenLoaded(List<Responden> respondens) {
                callback.onRespondenLoaded(respondens);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getRespondenByNamaResponden(String namaResponden, @NonNull LoadRespondenByNamaRespondenCallback callback) {

    }
}
