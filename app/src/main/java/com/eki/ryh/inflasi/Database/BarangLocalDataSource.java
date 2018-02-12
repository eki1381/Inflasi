package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Utils.AppExecutors;

import java.util.List;

/**
 * Created by user on 08/02/2018.
 */

public class BarangLocalDataSource implements BarangDataSource {

    private static volatile BarangLocalDataSource INSTANCE;

    private BarangDao mBarangDao;

    private AppExecutors mAppExecutors;

    private BarangLocalDataSource(@NonNull AppExecutors appExecutors,
                                  @NonNull BarangDao tasksDao) {
        mAppExecutors = appExecutors;
        mBarangDao = tasksDao;
    }

    public static BarangLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                    @NonNull BarangDao barangDao) {
        if (INSTANCE == null) {
            synchronized (BarangLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BarangLocalDataSource(appExecutors, barangDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getAllBarang(@NonNull final LoadBarangCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Barang> barangs = mBarangDao.getAllBarang();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (barangs.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onBarangLoaded(barangs);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getItemByItemName(final String itemName, @NonNull final LoadBarangIdByNamaBarang callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Barang> barangs = mBarangDao.getItemIdByItemName(itemName);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (barangs.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onBarangIdLoaded(barangs);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveBarang(final Barang brg) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                mBarangDao.insertBarang(brg);
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }
}