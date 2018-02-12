package com.eki.ryh.inflasi.Barang;

import com.eki.ryh.inflasi.Base.BaseContract;

//todo create BaseContract and import to this class
public interface AddBarangContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter {
        void saveBarang(String namaBarang);
    }
}
