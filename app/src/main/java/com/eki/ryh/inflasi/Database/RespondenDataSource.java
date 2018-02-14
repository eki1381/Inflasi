package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Responden;

import java.util.List;

/**
 * Created by user on 12/02/2018.
 */

public interface RespondenDataSource {
    interface LoadRespondenCallback {

        void onRespondenLoaded(List<Responden> respondens);

        void onDataNotAvailable();
    }

    interface LoadRespondenByNamaRespondenCallback {

        void onRespondenByNamaRespondenLoaded(List<Responden> respondens);

        void onDataNotAvailable();
    }

    void getAllResponden(@NonNull LoadRespondenCallback callback);

    void getRespondenByNamaResponden(String namaResponden, @NonNull LoadRespondenByNamaRespondenCallback callback);

    void saveResponden(Responden responden);
}
