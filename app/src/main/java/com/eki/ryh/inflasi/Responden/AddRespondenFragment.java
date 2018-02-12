package com.eki.ryh.inflasi.Responden;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.R;

public final class AddRespondenFragment extends BaseFragment implements AddRespondenContract.View {

    private AddRespondenContract.Presenter mPresenter;

    private EditText respondenId, respondenName;

    private Button entriBtn;

    // Your presenter is available using the mPresenter variable
    public AddRespondenFragment() {
        // Required empty public constructor
    }

    public static AddRespondenFragment newInstance() {
        return new AddRespondenFragment();
    }

    @Override
    public void setPresenter(AddRespondenContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_responden_layout, container, false);

        respondenId = view.findViewById(R.id.id_responden);
        respondenName = view.findViewById(R.id.nama_responden);

        entriBtn = view.findViewById(R.id.entri_btn);
        entriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.saveResponden(respondenId.getText().toString(), respondenName.getText().toString());
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
    public interface OnAddRespondenFragmentInteractionListener {
        // TODO: Update argument type and name
        void onAddRespondenFragmentInteraction();
    }
}
