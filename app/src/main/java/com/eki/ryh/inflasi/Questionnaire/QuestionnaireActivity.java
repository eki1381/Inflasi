package com.eki.ryh.inflasi.Questionnaire;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.Injection;
import com.eki.ryh.inflasi.R;
import com.github.florent37.awesomebar.AwesomeBar;

//todo create BaseActivity and import to this class
public class QuestionnaireActivity extends BaseActivity implements QuestionnaireFragment.OnQuestionnaireFragmentInteractionListener {

    QuestionnaireContract.Presenter mPresenter;

    AwesomeBar toolbar;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_questionnaire_layout);

        toolbar = findViewById(R.id.bar);

        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar.displayHomeAsUpEnabled(true);
        toolbar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        QuestionnaireFragment QuestionnaireFragment = (QuestionnaireFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (QuestionnaireFragment == null) {
            QuestionnaireFragment = QuestionnaireFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, QuestionnaireFragment);
            transaction.commit();
        }
        mPresenter = new QuestionnairePresenter(this, QuestionnaireFragment, Injection.provideBarangRepository(this), Injection.provideMerekRepository(this), Injection.provideRespondenRepository(this), Injection.provideQuestionnaireRepository(this));
        mPresenter.loadQuestionnaire(getIntent().getExtras().getInt("QUEST_SELECTED"));
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
