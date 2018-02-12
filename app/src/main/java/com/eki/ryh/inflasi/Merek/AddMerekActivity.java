package com.eki.ryh.inflasi.Merek;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.Injection;
import com.eki.ryh.inflasi.R;

//todo create BaseActivity and import to this class
public class AddMerekActivity extends BaseActivity implements AddMerekFragment.OnAddMerekFragmentInteractionListener {

    AddMerekContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_merek_layout);

        AddMerekFragment AddMerekFragment = (AddMerekFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (AddMerekFragment == null) {
            AddMerekFragment = AddMerekFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, AddMerekFragment);
            transaction.commit();
        }
        mPresenter = new AddMerekPresenter(this, AddMerekFragment, Injection.provideBarangRepository(this), Injection.provideMerekRepository(this));
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
    public void onAddMerekFragmentInteraction() {

    }
}
