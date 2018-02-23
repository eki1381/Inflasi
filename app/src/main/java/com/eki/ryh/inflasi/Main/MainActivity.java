package com.eki.ryh.inflasi.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.eki.ryh.inflasi.Base.BaseActivity;
import com.eki.ryh.inflasi.Injection;
import com.eki.ryh.inflasi.Questionnaire.QuestionnaireActivity;
import com.eki.ryh.inflasi.R;
import com.github.florent37.awesomebar.ActionItem;
import com.github.florent37.awesomebar.AwesomeBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.time.LocalDate;

//todo create BaseActivity and import to this class
public class MainActivity extends BaseActivity implements MainFragment.OnMainFragmentInteractionListener {

    MainContract.Presenter mPresenter;

    AwesomeBar toolbar;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);

        copyFile();

        toolbar = findViewById(R.id.bar);

        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar.displayHomeAsUpEnabled(false);
        toolbar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        MainFragment MainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_content);
        if (MainFragment == null) {
            MainFragment = MainFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout_content, MainFragment);
            transaction.commit();
        }
        mPresenter = new MainPresenter(this, MainFragment, Injection.provideQuestionnaireRepository(this));
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

    private void copyFile() {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (true) {
                String currentDBPath = getApplicationContext().getDatabasePath("Inflasi").getAbsolutePath();
                String backupDBPath = "Inflasi.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
