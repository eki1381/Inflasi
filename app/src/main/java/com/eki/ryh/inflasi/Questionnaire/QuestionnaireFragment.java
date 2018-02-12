package com.eki.ryh.inflasi.Questionnaire;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.R;

import java.util.ArrayList;
import java.util.List;

public final class QuestionnaireFragment extends BaseFragment implements QuestionnaireContract.View {

    private QuestionnaireContract.Presenter mPresenter;

    private Spinner barangSpinner, merekSpinner;

    private TextView satuanLabel;

    // Your presenter is available using the mPresenter variable
    public QuestionnaireFragment() {
        // Required empty public constructor
    }

    public static QuestionnaireFragment newInstance() {
        return new QuestionnaireFragment();
    }

    @Override
    public void setPresenter(QuestionnaireContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questionnaire_layout, container, false);

        barangSpinner = view.findViewById(R.id.jenis_barang);
        barangSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.populateMerek(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        merekSpinner = view.findViewById(R.id.kualitas_merek);

        satuanLabel = view.findViewById(R.id.satuan);

        return view;
    }

    @Override
    public void populateBarang(List<Barang> barangs) {
        List<String> namaBarang = new ArrayList<>();
        for(int i = 0;i < barangs.size();i++){
            namaBarang.add(barangs.get(i).getItemName());
        }

        ArrayAdapter<String> barangAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, namaBarang);

        barangAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        barangSpinner.setAdapter(barangAdapter);
    }

    @Override
    public void populateMerek(List<Merek> mereks) {
        List<String> namaMerek = new ArrayList<>();
        for(int i = 0;i < mereks.size();i++){
            namaMerek.add(mereks.get(i).getMerekName());
        }

        ArrayAdapter<String> merekAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, namaMerek);

        merekAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        merekSpinner.setAdapter(merekAdapter);
    }

    @Override
    public void setSatuan(String satuan) {
        satuanLabel.setText(satuan);
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
    public interface OnQuestionnaireFragmentInteractionListener {
        // TODO: Update argument type and name
        void onQuestionnaireFragmentInteraction();
    }
}
