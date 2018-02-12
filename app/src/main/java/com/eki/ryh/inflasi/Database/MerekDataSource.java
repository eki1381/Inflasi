package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Merek;

import java.util.List;

/**
 * Created by user on 09/02/2018.
 */

public interface MerekDataSource {

    interface LoadAllMerekCallback {
        void onAllMerekLoaded(List<Merek> mereks);

        void onDataNotAvailable();
    }

    interface LoadMerekCallback {

        void onMerekLoaded(List<Merek> mereks);

        void onDataNotAvailable();
    }

    void saveMerek(Merek merek);

    void getAllMerek(@NonNull LoadAllMerekCallback callback);

    void getMerekByBarangId(String itemId, @NonNull LoadMerekCallback callback);
}