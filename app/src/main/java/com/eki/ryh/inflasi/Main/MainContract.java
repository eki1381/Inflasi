package com.eki.ryh.inflasi.Main;

import com.eki.ryh.inflasi.Base.BaseContract;

import java.util.List;

//todo create BaseContract and import to this class
public interface MainContract {

    interface View extends BaseContract.View<Presenter> {
        void showList(List<MainRv> mainRvList);
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
