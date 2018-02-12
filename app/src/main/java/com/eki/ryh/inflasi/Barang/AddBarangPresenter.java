package com.eki.ryh.inflasi.Barang;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.BarangDataSource;
import com.eki.ryh.inflasi.Model.Barang;

public class AddBarangPresenter extends BasePresenter implements AddBarangContract.Presenter {

    private AddBarangContract.View mView;

    private Context mContext;

    private BarangDataSource barangDataSource;

    public AddBarangPresenter(@NonNull Context context, @NonNull AddBarangContract.View view, @NonNull BarangDataSource barangDataSource) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
        this.barangDataSource = barangDataSource;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void saveBarang(String namaBarang) {
        Barang brg = new Barang(namaBarang);
        barangDataSource.saveBarang(brg);
    }
}
