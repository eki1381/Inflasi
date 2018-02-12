package com.eki.ryh.inflasi.Barang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.R;

public final class AddBarangFragment extends BaseFragment implements AddBarangContract.View {

    private AddBarangContract.Presenter mPresenter;

    private Button entriBtn;
    private EditText nameFld;

    // Your presenter is available using the mPresenter variable
    public AddBarangFragment() {
        // Required empty public constructor
    }

    public static AddBarangFragment newInstance() {
        return new AddBarangFragment();
    }

    @Override
    public void setPresenter(AddBarangContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_barang_layout, container, false);

        nameFld = view.findViewById(R.id.nama_barang);
        entriBtn = view.findViewById(R.id.entri_btn);
        entriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.saveBarang(nameFld.getText().toString());
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
    public interface OnAddFragmentInteractionListener {
        // TODO: Update argument type and name
        void onAddFragmentInteraction();
    }
}
