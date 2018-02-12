package com.eki.ryh.inflasi.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eki.ryh.inflasi.Barang.AddBarangActivity;
import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.Merek.AddMerekActivity;
import com.eki.ryh.inflasi.Questionnaire.QuestionnaireActivity;
import com.eki.ryh.inflasi.R;
import com.eki.ryh.inflasi.Responden.AddRespondenActivity;

public final class MainFragment extends BaseFragment implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private Button cacahBaru, tambahBarang, tambahMerek, tambahResponden;

    // Your presenter is available using the mPresenter variable
    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_layout, container, false);

        tambahBarang = view.findViewById(R.id.tambah_barang);
        tambahBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddBarangActivity.class);
                startActivity(intent);
            }
        });

        tambahMerek = view.findViewById(R.id.tambah_merek);
        tambahMerek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddMerekActivity.class);
                startActivity(intent);
            }
        });

        tambahResponden = view.findViewById(R.id.tambah_responden);
        tambahResponden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddRespondenActivity.class);
                startActivity(intent);
            }
        });

        cacahBaru = view.findViewById(R.id.cacah_baru);
        cacahBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuestionnaireActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnMainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction();
    }
}
