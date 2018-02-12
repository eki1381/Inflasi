package com.eki.ryh.inflasi.Base;

/**
 * Created by user on 05/02/2018.
 */

public interface BaseContract {

    interface View<T extends Presenter> {
        void setPresenter(T presenter);
    }

    interface Presenter {
        void start();
        void stop();
    }
}