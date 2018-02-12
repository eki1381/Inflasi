package com.eki.ryh.inflasi;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Database.BarangDataSource;
import com.eki.ryh.inflasi.Database.BarangLocalDataSource;
import com.eki.ryh.inflasi.Database.BarangRepository;
import com.eki.ryh.inflasi.Database.InflasiDatabase;
import com.eki.ryh.inflasi.Database.MerekLocalDataSource;
import com.eki.ryh.inflasi.Database.MerekRepository;
import com.eki.ryh.inflasi.Utils.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by user on 08/02/2018.
 */

public class Injection {
    public static BarangRepository provideBarangRepository(@NonNull Context context) {
        checkNotNull(context);
        InflasiDatabase database = InflasiDatabase.getInstance(context);
        return BarangRepository.getInstance(BarangLocalDataSource.getInstance(new AppExecutors(),
                        database.barangDao()));
    }

    public static MerekRepository provideMerekRepository(@NonNull Context context) {
        checkNotNull(context);
        InflasiDatabase database = InflasiDatabase.getInstance(context);
        return MerekRepository.getInstance(MerekLocalDataSource.getInstance(new AppExecutors(),
                database.merekDao()));
    }
}
