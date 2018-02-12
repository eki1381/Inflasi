package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Barang;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by user on 08/02/2018.
 */

public class BarangRepository implements BarangDataSource {

    private static BarangRepository INSTANCE = null;

    private final BarangDataSource mBarangLocalDataSource;

    Map<String, Barang> mCachedBarang;

    boolean mCacheIsDirty = false;

    private BarangRepository(@NonNull BarangDataSource barangLocalDataSource) {
        mBarangLocalDataSource = checkNotNull(barangLocalDataSource);
    }

    public static BarangRepository getInstance(BarangDataSource barangLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new BarangRepository(barangLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getAllBarang(@NonNull final LoadBarangCallback callback) {
        checkNotNull(callback);
        mBarangLocalDataSource.getAllBarang(new LoadBarangCallback() {
            @Override
            public void onBarangLoaded(List<Barang> barang) {
                refreshCache(barang);
                callback.onBarangLoaded(barang);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getItemByItemName(String itemName, @NonNull final LoadBarangIdByNamaBarang callback) {
        checkNotNull(callback);
        mBarangLocalDataSource.getItemByItemName(itemName, new LoadBarangIdByNamaBarang() {
            @Override
            public void onBarangIdLoaded(List<Barang> barang) {
                refreshCache(barang);
                callback.onBarangIdLoaded(barang);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void saveBarang(Barang brg) {
        checkNotNull(brg);
        mBarangLocalDataSource.saveBarang(brg);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedBarang == null) {
            mCachedBarang = new LinkedHashMap<>();
        }
        mCachedBarang.put(brg.getItemId(), brg);
    }

    private void refreshCache(List<Barang> barangs) {
        if (mCachedBarang == null) {
            mCachedBarang = new LinkedHashMap<>();
        }
        mCachedBarang.clear();
        for (Barang barang : barangs) {
            mCachedBarang.put(barang.getItemId(), barang);
        }
        mCacheIsDirty = false;
    }
}
