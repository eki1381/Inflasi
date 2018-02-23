package com.eki.ryh.inflasi.Main;

import android.content.Context;
import android.support.annotation.NonNull;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.QuestionnaireDataSource;
import com.eki.ryh.inflasi.InnerMain.InnerMainPresenter;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainPresenter extends BasePresenter implements MainContract.Presenter, QuestionnaireDataSource.LoadBulanDistinctCallback {

    private MainContract.View mView;

    private Context mContext;

    private QuestionnaireDataSource questionnaireDataSource;

    public MainPresenter(@NonNull Context context, @NonNull MainContract.View view, @NonNull QuestionnaireDataSource questionnaireDataSource) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
        this.questionnaireDataSource = questionnaireDataSource;
    }

    @Override
    public void start() {
        questionnaireDataSource.getBulanDistinct(this);
    }

    @Override
    public void stop() {

    }

    @Override
    public void onBulanDistinctLoaded(List<String> bulans) {
        List<MainRv> mainRvList = new ArrayList<>();
        for (int i = 0; i < bulans.size(); i++) {
            ColorGenerator generator = ColorGenerator.MATERIAL;
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(String.valueOf(bulans.get(i).charAt(0)), generator.getRandomColor());
            mainRvList.add(new MainRv(drawable, bulans.get(i)));
        }
        mView.showList(mainRvList);
    }

    @Override
    public void onDataNotAvailable() {

    }

}
