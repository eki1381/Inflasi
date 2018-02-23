package com.eki.ryh.inflasi.InnerMain;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.Injection;
import com.eki.ryh.inflasi.R;
import com.github.florent37.awesomebar.AwesomeBar;

//todo create BaseActivity and import to this class
public class InnerMainActivity extends BaseActivity implements InnerMainFragment.OnInnerMainFragmentInteractionListener {

    InnerMainContract.Presenter mPresenter;

    AwesomeBar toolbar;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inner_main_layout);

        toolbar = findViewById(R.id.bar);

        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar.displayHomeAsUpEnabled(true);
        toolbar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        InnerMainFragment InnerMainFragment = (InnerMainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (InnerMainFragment == null) {
            InnerMainFragment = InnerMainFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, InnerMainFragment);
            transaction.commit();
        }
        mPresenter = new InnerMainPresenter(this, InnerMainFragment, Injection.provideQuestionnaireRepository(this));

        mPresenter.loadQuestionnaireList(getIntent().getExtras().getString("BULAN_SELECTED"));
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
    public void onInnerMainFragmentInteraction() {

    }
}
