package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Responden;
import com.eki.ryh.inflasi.Utils.AppExecutors;

import java.util.List;

/**
 * Created by user on 12/02/2018.
 */

public class RespondenLocalDataSource implements RespondenDataSource {

    private static volatile RespondenLocalDataSource INSTANCE;

    private RespondenDao mRespondenDao;

    private AppExecutors mAppExecutors;

    private RespondenLocalDataSource(@NonNull AppExecutors appExecutors,
                                     @NonNull RespondenDao respondenDao) {
        mAppExecutors = appExecutors;
        mRespondenDao = respondenDao;
    }

    public static RespondenLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                       @NonNull RespondenDao respondenDao) {
        if (INSTANCE == null) {
            synchronized (RespondenLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RespondenLocalDataSource(appExecutors, respondenDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getAllResponden(@NonNull final LoadRespondenCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Responden> respondens = mRespondenDao.getAllResponden();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (respondens.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onRespondenLoaded(respondens);
                        }
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getRespondenByNamaResponden(String namaResponden, @NonNull LoadRespondenByNamaRespondenCallback callback) {

    }

    @Override
    public void saveResponden(final Responden responden) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                mRespondenDao.insertResponden(responden);
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }
}