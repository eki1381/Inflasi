package com.eki.ryh.inflasi.Responden;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;

public class AddRespondenPresenter extends BasePresenter implements AddRespondenContract.Presenter {

    private AddRespondenContract.View mView;

    private Context mContext;

    public AddRespondenPresenter(@NonNull Context context, @NonNull AddRespondenContract.View view) {
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

    @Override
    public void saveResponden(String id, String respondenName) {

    }
}
