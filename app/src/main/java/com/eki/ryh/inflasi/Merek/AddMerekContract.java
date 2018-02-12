package com.eki.ryh.inflasi.Merek;

import com.eki.ryh.inflasi.Base.BaseContract;
import com.eki.ryh.inflasi.Model.Barang;

import java.util.List;

//todo create BaseContract and import to this class
public interface AddMerekContract {

    interface View extends BaseContract.View<Presenter> {
        void populateBarang(List<Barang> barangs);
    }

    interface Presenter extends BaseContract.Presenter {
        void saveMerek(String namaMerek, String satuan, String itemName);
    }
}
