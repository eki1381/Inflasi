package com.eki.ryh.inflasi.Questionnaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.InnerMain.InnerMainRv;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Model.Questionnaire;
import com.eki.ryh.inflasi.Model.Responden;
import com.eki.ryh.inflasi.R;
import com.farbod.labelledspinner.LabelledSpinner;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.List;

public final class QuestionnaireFragment extends BaseFragment implements QuestionnaireContract.View, CalendarDatePickerDialogFragment.OnDateSetListener {

    private QuestionnaireContract.Presenter mPresenter;

    private static final String FRAG_TAG_DATE_PICKER = "fragment_date_picker_name";

    private LabelledSpinner respondenSpinner;

    private TextView barangLabel, merekLabel, bulanLabel, satuanLabel;

    private EditText hargaFld;

    private MaterialFancyButton entriBtn;

    private String responden;

    private int spinnerPos;

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

        barangLabel = view.findViewById(R.id.barang_label);

        merekLabel = view.findViewById(R.id.merek_label);

        respondenSpinner = view.findViewById(R.id.responden_spinner);
        respondenSpinner.setOnItemChosenListener(new LabelledSpinner.OnItemChosenListener() {
            @Override
            public void onItemChosen(View labelledSpinner, AdapterView<?> adapterView, View itemView, int position, long id) {
                responden = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingChosen(View labelledSpinner, AdapterView<?> adapterView) {

            }
        });

        barangLabel = view.findViewById(R.id.barang_label);

        merekLabel = view.findViewById(R.id.merek_label);

        bulanLabel = view.findViewById(R.id.bulan_label);

        satuanLabel = view.findViewById(R.id.satuan_label);

        hargaFld = view.findViewById(R.id.harga);

        entriBtn = view.findViewById(R.id.entri_btn);
        entriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.updateQuestionnaire(responden, Integer.parseInt(hargaFld.getText().toString()));
            }
        });

        return view;
    }

    @Override
    public void populateResponden(List<Responden> respondens) {
        List<String> namaResponden = new ArrayList<>();
        for (int i = 0; i < respondens.size(); i++) {
            namaResponden.add(respondens.get(i).getRespName());
        }

        ArrayAdapter<String> respondenAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, namaResponden);

        respondenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        respondenSpinner.setCustomAdapter(respondenAdapter);
        respondenSpinner.setSelection(spinnerPos);
    }

    @Override
    public void setSatuan(String satuan) {
        satuanLabel.setText(satuan);
    }

    @Override
    public void loadQuestionnaire(Questionnaire questionnaire) {
        barangLabel.setText(questionnaire.getNamaBarang());
        merekLabel.setText(questionnaire.getNamaMerek());
        spinnerPos = respondenToPosition(questionnaire.getNamaResponden());
        bulanLabel.setText(questionnaire.getBulan());
        satuanLabel.setText(questionnaire.getSatuan());
        hargaFld.setText(String.valueOf(questionnaire.getHarga()));
    }

    private int respondenToPosition(String responden){
        if (responden.equals("Siantan Mart")){
            return 0;
        }else if(responden.equals("Kedai Cece")){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public void successNotification(){
        Toast.makeText(getActivity(), "Entri data sukses", Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        String bulan = "-";
        if (monthOfYear == 0) {
            bulan = "Januari";
        }
        if (monthOfYear == 1) {
            bulan = "Februari";
        }
        if (monthOfYear == 2) {
            bulan = "Maret";
        }
        if (monthOfYear == 3) {
            bulan = "April";
        }
        if (monthOfYear == 4) {
            bulan = "Mei";
        }
        if (monthOfYear == 5) {
            bulan = "Juni";
        }
        if (monthOfYear == 6) {
            bulan = "Juli";
        }
        if (monthOfYear == 7) {
            bulan = "Agustus";
        }
        if (monthOfYear == 8) {
            bulan = "September";
        }
        if (monthOfYear == 9) {
            bulan = "Oktober";
        }
        if (monthOfYear == 10) {
            bulan = "November";
        }
        if (monthOfYear == 11) {
            bulan = "Desember";
        }

        bulanLabel.setText(bulan);
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
