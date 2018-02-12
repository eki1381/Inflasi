package com.eki.ryh.inflasi.Merek;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.Model.Barang;
import com.eki.ryh.inflasi.R;

import java.util.ArrayList;
import java.util.List;

public final class AddMerekFragment extends BaseFragment implements AddMerekContract.View {

    private AddMerekContract.Presenter mPresenter;

    private EditText merekIdFld, merekNameFld, merekSatuanFld;

    private Spinner barangSpinner;

    private Button entriBtn;

    // Your presenter is available using the mPresenter variable
    public AddMerekFragment() {
        // Required empty public constructor
    }

    public static AddMerekFragment newInstance() {
        return new AddMerekFragment();
    }

    @Override
    public void setPresenter(AddMerekContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_merek_layout, container, false);

        merekIdFld = view.findViewById(R.id.id_merek);
        merekNameFld = view.findViewById(R.id.nama_merek);
        merekSatuanFld = view.findViewById(R.id.satuan);

        barangSpinner = view.findViewById(R.id.jenis_barang);

        entriBtn = view.findViewById(R.id.entri_btn);
        entriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.saveMerek(merekNameFld.getText().toString(), merekSatuanFld.getText().toString(), barangSpinner.getSelectedItem().toString());
            }
        });

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
    public interface OnAddMerekFragmentInteractionListener {
        // TODO: Update argument type and name
        void onAddMerekFragmentInteraction();
    }
}
