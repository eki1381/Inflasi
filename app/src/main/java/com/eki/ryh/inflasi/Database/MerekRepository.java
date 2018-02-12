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

    Map<String, Merek> mCachedMerek;

    boolean mCacheIsDirty = false;

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

        // Do in memory cache update to keep the app UI up to date
        if (mCachedMerek == null) {
            mCachedMerek = new LinkedHashMap<>();
        }
        mCachedMerek.put(merek.getItemId(), merek);
    }

    @Override
    public void getAllMerek(@NonNull final LoadAllMerekCallback callback) {
        checkNotNull(callback);
        mMerekLocalDataSource.getAllMerek(new LoadAllMerekCallback() {
            @Override
            public void onAllMerekLoaded(List<Merek> mereks) {
                refreshCache(mereks);
                callback.onAllMerekLoaded(mereks);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getMerekByBarangId(String itemId, @NonNull final LoadMerekCallback callback) {
        checkNotNull(callback);
        mMerekLocalDataSource.getMerekByBarangId(itemId, new LoadMerekCallback() {
            @Override
            public void onMerekLoaded(List<Merek> mereks) {
                refreshCache(mereks);
                callback.onMerekLoaded(mereks);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    private void refreshCache(List<Merek> mereks) {
        if (mCachedMerek == null) {
            mCachedMerek = new LinkedHashMap<>();
        }
        mCachedMerek.clear();
        for (Merek merek : mereks) {
            mCachedMerek.put(merek.getItemId(), merek);
        }
        mCacheIsDirty = false;
    }
}
