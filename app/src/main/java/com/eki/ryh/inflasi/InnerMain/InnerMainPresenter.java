package com.eki.ryh.inflasi.InnerMain;

import android.content.Context;
import android.support.annotation.NonNull;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.QuestionnaireDataSource;
import com.eki.ryh.inflasi.Model.Questionnaire;

import java.util.ArrayList;
import java.util.List;

public class InnerMainPresenter extends BasePresenter implements InnerMainContract.Presenter, QuestionnaireDataSource.LoadQuestionnaireByBulanCallback {

    private InnerMainContract.View mView;

    private Context mContext;

    private QuestionnaireDataSource questionnaireDataSource;

    public InnerMainPresenter(@NonNull Context context, @NonNull InnerMainContract.View view, @NonNull QuestionnaireDataSource questionnaireDataSource) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
        this.questionnaireDataSource = questionnaireDataSource;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onQuestionnaireByBulanLoaded(List<Questionnaire> questionnaires) {
        List<InnerMainRv> innerMainRvList = new ArrayList<>();
        for (int i = 0; i < questionnaires.size(); i++) {
            ColorGenerator generator = ColorGenerator.MATERIAL;
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(String.valueOf(questionnaires.get(i).getNamaMerek().charAt(0)), generator.getRandomColor());
            innerMainRvList.add(new InnerMainRv(questionnaires.get(i).getQuestId(), questionnaires.get(i).getHarga(), questionnaires.get(i).getBulan(), questionnaires.get(i).getNamaBarang(), questionnaires.get(i).getNamaMerek(), questionnaires.get(i).getSatuan(), questionnaires.get(i).getNamaResponden(), drawable));
        }
        mView.showList(innerMainRvList);
    }

    @Override
    public void onDataNotAvailable() {

    }

    @Override
    public void loadQuestionnaireList(String bulan) {
        questionnaireDataSource.getQuestionnaireByBulan(bulan, this);
    }
}
