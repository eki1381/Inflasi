package com.eki.ryh.inflasi.Questionnaire;

import com.eki.ryh.inflasi.Base.BaseContract;
import com.eki.ryh.inflasi.InnerMain.InnerMainRv;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Model.Questionnaire;
import com.eki.ryh.inflasi.Model.Responden;

import java.util.List;

//todo create BaseContract and import to this class
public interface QuestionnaireContract {

    interface View extends BaseContract.View<Presenter> {
        void populateResponden(List<Responden> respondens);

        void setSatuan(String satuan);

        void loadQuestionnaire(Questionnaire questionnaire);

        void successNotification();
    }

    interface Presenter extends BaseContract.Presenter {
        void populateResponden();

        void updateQuestionnaire(String namaResponden, int harga);

        void loadQuestionnaire(int questId);
    }
}
