package com.eki.ryh.inflasi.Questionnaire;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.Injection;
import com.eki.ryh.inflasi.R;

//todo create BaseActivity and import to this class
public class QuestionnaireActivity extends BaseActivity implements QuestionnaireFragment.OnQuestionnaireFragmentInteractionListener {

    QuestionnaireContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_questionnaire_layout);

        QuestionnaireFragment QuestionnaireFragment = (QuestionnaireFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (QuestionnaireFragment == null) {
            QuestionnaireFragment = QuestionnaireFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, QuestionnaireFragment);
            transaction.commit();
        }
        mPresenter = new QuestionnairePresenter(this, QuestionnaireFragment, Injection.provideBarangRepository(this), Injection.provideMerekRepository(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Override
    public void onQuestionnaireFragmentInteraction() {

    }
}
