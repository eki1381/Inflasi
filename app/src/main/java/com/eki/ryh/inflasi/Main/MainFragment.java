package com.eki.ryh.inflasi.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.InnerMain.InnerMainActivity;
import com.eki.ryh.inflasi.Questionnaire.QuestionnaireActivity;
import com.eki.ryh.inflasi.R;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.binder.ViewBinder;

import java.util.List;

public final class MainFragment extends BaseFragment implements MainContract.View {

    private MainContract.Presenter mPresenter;

    RecyclerView recyclerView;

    RendererRecyclerViewAdapter adapter;

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

        recyclerView = view.findViewById(R.id.recycler_view);

        adapter = new RendererRecyclerViewAdapter(getActivity());
        adapter.registerRenderer(new ViewBinder<>(
                R.layout.mainrv_layout,
                MainRv.class,
                (model, finder, payloads) -> finder
                        .setText(R.id.title, model.getTitle())
                        .setImageDrawable(R.id.image_view, model.getImage())
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity().getApplicationContext(), InnerMainActivity.class);
                                Bundle extras = new Bundle();
                                extras.putString("BULAN_SELECTED", model.getTitle());
                                intent.putExtras(extras);
                                startActivity(intent);
                            }
                        })
        ));

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void showList(List<MainRv> mainRvList) {
        adapter.setItems(mainRvList);
        adapter.notifyDataSetChanged();
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
