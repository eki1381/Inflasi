package com.eki.ryh.inflasi.Responden;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.R;

//todo create BaseActivity and import to this class
public class AddRespondenActivity extends BaseActivity implements AddRespondenFragment.OnAddRespondenFragmentInteractionListener {

    AddRespondenContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_responden_layout);

        AddRespondenFragment AddRespondenFragment = (AddRespondenFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (AddRespondenFragment == null) {
            AddRespondenFragment = AddRespondenFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, AddRespondenFragment);
            transaction.commit();
        }
        mPresenter = new AddRespondenPresenter(this, AddRespondenFragment);
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
    public void onAddRespondenFragmentInteraction() {

    }
}
