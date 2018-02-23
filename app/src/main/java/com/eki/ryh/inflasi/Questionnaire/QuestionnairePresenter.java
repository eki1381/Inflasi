package com.eki.ryh.inflasi.Questionnaire;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Base.BasePresenter;
import com.eki.ryh.inflasi.Database.BarangDataSource;
import com.eki.ryh.inflasi.Database.MerekDataSource;
import com.eki.ryh.inflasi.Database.QuestionnaireDataSource;
import com.eki.ryh.inflasi.Database.RespondenDataSource;
import com.eki.ryh.inflasi.InnerMain.InnerMainRv;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Model.Questionnaire;
import com.eki.ryh.inflasi.Model.Responden;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class QuestionnairePresenter extends BasePresenter implements QuestionnaireContract.Presenter, RespondenDataSource.LoadRespondenCallback, QuestionnaireDataSource.LoadQuestionnaireByIdCallback, QuestionnaireDataSource.UpdateQuestionnaireCallback {

    private QuestionnaireContract.View mView;

    private Context mContext;

    private BarangDataSource barangDataSource;

    private MerekDataSource merekDataSource;

    private RespondenDataSource respondenDataSource;

    private QuestionnaireDataSource questionnaireDataSource;

    private Questionnaire questionnaire;


    public QuestionnairePresenter(@NonNull Context context, @NonNull QuestionnaireContract.View view, @NonNull BarangDataSource barangDataSource, @NonNull MerekDataSource merekDataSource, @NonNull RespondenDataSource respondenDataSource, @NonNull QuestionnaireDataSource questionnaireDataSource) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
        this.barangDataSource = barangDataSource;
        this.merekDataSource = merekDataSource;
        this.respondenDataSource = respondenDataSource;
        this.questionnaireDataSource = questionnaireDataSource;
    }

    @Override
    public void start() {
        populateResponden();
    }

    @Override
    public void stop() {

    }

    @Override
    public void populateResponden() {
        respondenDataSource.getAllResponden(this);
    }

    @Override
    public void updateQuestionnaire(String namaResponden, int harga) {
        questionnaire.setNamaResponden(namaResponden);
        questionnaire.setHarga(harga);
        questionnaireDataSource.updateQuestionnaire(questionnaire, this);
    }

    @Override
    public void loadQuestionnaire(int questId) {
        questionnaireDataSource.getQuestionnaireById(questId, this);
    }

    @Override
    public void onRespondenLoaded(List<Responden> respondens) {
        mView.populateResponden(respondens);
    }

    @Override
    public void onQuestionnaireByIdLoaded(List<Questionnaire> questionnaires) {
        this.questionnaire = questionnaires.get(0);
        mView.loadQuestionnaire(questionnaires.get(0));
    }

    @Override
    public void onDataNotAvailable() {

    }

    @Override
    public void onQuestionnaireUpdated(int respond) {
        if(respond == 1){
            mView.successNotification();
        }else{

        }
    }
}
