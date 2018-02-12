package com.eki.ryh.inflasi.Merek;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.BarangDataSource;
import com.eki.ryh.inflasi.Database.MerekDataSource;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;

import java.util.List;

public class AddMerekPresenter extends BasePresenter implements AddMerekContract.Presenter, BarangDataSource.LoadBarangCallback, BarangDataSource.LoadBarangIdByNamaBarang, MerekDataSource.LoadAllMerekCallback {

    private AddMerekContract.View mView;

    private Context mContext;

    private BarangDataSource barangDataSource;

    private MerekDataSource merekDataSource;

    private String id, namaMerek, satuan;

    public AddMerekPresenter(@NonNull Context context, @NonNull AddMerekContract.View view, @NonNull BarangDataSource barangDataSource, @NonNull MerekDataSource merekDataSource) {
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
    public void saveMerek(String namaMerek, String satuan, String itemName) {
        this.id = id;
        this.namaMerek = namaMerek;
        this.satuan = satuan;
        barangDataSource.getItemByItemName(itemName, this);
    }

    private void populateBarang(){
        barangDataSource.getAllBarang(this);
    }

    @Override
    public void onBarangLoaded(List<Barang> barang) {
        mView.populateBarang(barang);
    }

    @Override
    public void onBarangIdLoaded(List<Barang> barang) {
        Merek merek = new Merek(namaMerek, satuan, barang.get(0).getItemId());
        merekDataSource.saveMerek(merek);
        merekDataSource.getAllMerek(this);
    }

    @Override
    public void onAllMerekLoaded(List<Merek> mereks) {
        for(int i = 0; i < mereks.size();i++){
            System.out.println(mereks.get(i).getMerekId() + " " + mereks.get(i).getMerekName() + " " + mereks.get(i).getItemId());
        }
    }

    @Override
    public void onDataNotAvailable() {

    }
}
