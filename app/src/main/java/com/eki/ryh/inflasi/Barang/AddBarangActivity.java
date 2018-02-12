package com.eki.ryh.inflasi.Barang;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.Injection;
import com.eki.ryh.inflasi.R;

//todo create BaseActivity and import to this class
public class AddBarangActivity extends BaseActivity implements AddBarangFragment.OnAddFragmentInteractionListener {

    AddBarangContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_barang_layout);

        AddBarangFragment AddBarangFragment = (AddBarangFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (AddBarangFragment == null) {
            AddBarangFragment = AddBarangFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, AddBarangFragment);
            transaction.commit();
        }



        mPresenter = new AddBarangPresenter(this, AddBarangFragment, Injection.provideBarangRepository(getApplicationContext()));
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
    public void onAddFragmentInteraction() {

    }
}
