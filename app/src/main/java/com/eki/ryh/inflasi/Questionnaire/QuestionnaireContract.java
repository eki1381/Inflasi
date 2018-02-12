package com.eki.ryh.inflasi.Questionnaire;

import com.eki.ryh.inflasi.Base.BaseContract;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;

import java.util.List;

//todo create BaseContract and import to this class
public interface QuestionnaireContract {

    interface View extends BaseContract.View<Presenter> {
        void populateBarang(List<Barang> barangs);

        void populateMerek(List<Merek> mereks);

        void setSatuan(String satuan);
    }

    interface Presenter extends BaseContract.Presenter {
        void populateBarang();

        void populateMerek(String merekId);

        void populateResponden();

        void saveTask();
    }
}
