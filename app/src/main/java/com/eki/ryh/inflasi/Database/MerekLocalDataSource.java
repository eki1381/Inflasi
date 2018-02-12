package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Utils.AppExecutors;

import java.util.List;

/**
 * Created by user on 09/02/2018.
 */

public class MerekLocalDataSource implements MerekDataSource {

    private static volatile MerekLocalDataSource INSTANCE;

    private MerekDao mMerekDao;

    private AppExecutors mAppExecutors;

    private MerekLocalDataSource(@NonNull AppExecutors appExecutors,
                                  @NonNull MerekDao merekDao) {
        mAppExecutors = appExecutors;
        mMerekDao = merekDao;
    }

    public static MerekLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                    @NonNull MerekDao merekDao) {
        if (INSTANCE == null) {
            synchronized (BarangLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MerekLocalDataSource(appExecutors, merekDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveMerek(final Merek merek) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                mMerekDao.insertMerek(merek);
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void getAllMerek(@NonNull final LoadAllMerekCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Merek> mereks = mMerekDao.getAllMerek();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (mereks.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onAllMerekLoaded(mereks);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getMerekByBarangId(final String itemId, @NonNull final LoadMerekCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Merek> mereks = mMerekDao.getMerekByBarangId(itemId);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (mereks.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onMerekLoaded(mereks);
                        }
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);
    }
}
