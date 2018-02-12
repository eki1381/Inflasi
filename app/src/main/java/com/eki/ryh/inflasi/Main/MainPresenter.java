package com.eki.ryh.inflasi.Main;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;

public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private Context mContext;

    public MainPresenter(@NonNull Context context, @NonNull MainContract.View view) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
