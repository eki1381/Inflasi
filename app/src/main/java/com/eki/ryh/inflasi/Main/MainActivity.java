package com.eki.ryh.inflasi.Main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.R;

//todo create BaseActivity and import to this class
public class MainActivity extends BaseActivity implements MainFragment.OnMainFragmentInteractionListener {

    MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);

        MainFragment MainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (MainFragment == null) {
            MainFragment = MainFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, MainFragment);
            transaction.commit();
        }
        mPresenter = new MainPresenter(this, MainFragment);
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
    public void onMainFragmentInteraction() {

    }
}
