package com.eki.ryh.inflasi.Responden;

import com.eki.ryh.inflasi.Base.BaseContract;

//todo create BaseContract and import to this class
public interface AddRespondenContract {

    interface View extends BaseContract.View<Presenter> {

    }

    interface Presenter extends BaseContract.Presenter {
        void saveResponden(String respondenName);
    }
}
