package com.eki.ryh.inflasi.Responden;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.RespondenDataSource;
import com.eki.ryh.inflasi.Model.Responden;

import java.util.List;

public class AddRespondenPresenter extends BasePresenter implements AddRespondenContract.Presenter, RespondenDataSource.LoadRespondenCallback {

    private AddRespondenContract.View mView;

    private Context mContext;

    private RespondenDataSource respondenDataSource;

    public AddRespondenPresenter(@NonNull Context context, @NonNull AddRespondenContract.View view, @NonNull RespondenDataSource respondenDataSource) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
        this.respondenDataSource = respondenDataSource;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void saveResponden(String respondenName) {
        Responden responden = new Responden(respondenName);
        respondenDataSource.saveResponden(responden);
    }

    @Override
    public void onRespondenLoaded(List<Responden> respondens) {
        for(int i = 0;i < respondens.size();i++){
            System.out.println(respondens.get(i).getRespName());
        }
    }

    @Override
    public void onDataNotAvailable() {

    }
}
