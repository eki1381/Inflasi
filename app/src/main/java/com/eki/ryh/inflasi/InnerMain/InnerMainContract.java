package com.eki.ryh.inflasi.InnerMain;

import com.eki.ryh.inflasi.Base.BaseContract;

import java.util.List;

//todo create BaseContract and import to this class
public interface InnerMainContract {

    interface View extends BaseContract.View<Presenter> {
        void showList(List<InnerMainRv> innerMainRvList);
    }

    interface Presenter extends BaseContract.Presenter {
        void loadQuestionnaireList(String bulan);
    }
}
