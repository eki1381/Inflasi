package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Barang;

import java.util.List;

/**
 * Created by user on 08/02/2018.
 */

public interface BarangDataSource {

    interface LoadBarangCallback {

        void onBarangLoaded(List<Barang> barang);

        void onDataNotAvailable();
    }

    interface LoadBarangIdByNamaBarang {
        void onBarangIdLoaded(List<Barang> barang);

        void onDataNotAvailable();
    }

    void getAllBarang(@NonNull LoadBarangCallback callback);

    void getItemByItemName(String itemName, @NonNull LoadBarangIdByNamaBarang callback);

    void saveBarang(Barang brg);
}