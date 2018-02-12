package com.eki.ryh.inflasi.Questionnaire;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.BarangDataSource;
import com.eki.ryh.inflasi.Database.MerekDataSource;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;

import java.util.List;

public class QuestionnairePresenter extends BasePresenter implements QuestionnaireContract.Presenter, BarangDataSource.LoadBarangCallback, MerekDataSource.LoadMerekCallback, BarangDataSource.LoadBarangIdByNamaBarang {

    private QuestionnaireContract.View mView;

    private Context mContext;

    private BarangDataSource barangDataSource;

    private MerekDataSource merekDataSource;


    public QuestionnairePresenter(@NonNull Context context, @NonNull QuestionnaireContract.View view, @NonNull BarangDataSource barangDataSource, @NonNull MerekDataSource merekDataSource) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
        this.barangDataSource = barangDataSource;
        this.merekDataSource = merekDataSource;
    }

    @Override
    public void start() {
        populateBarang();
    }

    @Override
    public void stop() {

    }

    @Override
    public void populateBarang() {
        barangDataSource.getAllBarang(this);
    }

    @Override
    public void populateMerek(String merekName) {
        barangDataSource.getItemByItemName(merekName, this);
    }

    @Override
    public void populateResponden() {

    }

    @Override
    public void saveTask() {

    }

    @Override
    public void onBarangLoaded(List<Barang> barang) {
        mView.populateBarang(barang);
    }

    @Override
    public void onMerekLoaded(List<Merek> mereks) {
        mView.populateMerek(mereks);
        mView.setSatuan(mereks.get(0).getSatuan().toString());
    }

    @Override
    public void onBarangIdLoaded(List<Barang> barang) {
        merekDataSource.getMerekByBarangId(barang.get(0).getItemId(), this);
    }

    @Override
    public void onDataNotAvailable() {

    }
}
