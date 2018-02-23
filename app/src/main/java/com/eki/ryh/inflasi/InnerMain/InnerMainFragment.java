package com.eki.ryh.inflasi.InnerMain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eki.ryh.inflasi.Base.BaseFragment;
import com.eki.ryh.inflasi.Main.MainRv;
import com.eki.ryh.inflasi.Questionnaire.QuestionnaireActivity;
import com.eki.ryh.inflasi.R;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.binder.ViewBinder;
import com.google.gson.Gson;

import java.util.List;

public final class InnerMainFragment extends BaseFragment implements InnerMainContract.View {

    private InnerMainContract.Presenter mPresenter;

    RecyclerView recyclerView;

    RendererRecyclerViewAdapter adapter;

    // Your presenter is available using the mPresenter variable
    public InnerMainFragment() {
        // Required empty public constructor
    }

    public static InnerMainFragment newInstance() {
        return new InnerMainFragment();
    }

    @Override
    public void setPresenter(InnerMainContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inner_main_layout, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        adapter = new RendererRecyclerViewAdapter(getActivity());
        adapter.registerRenderer(new ViewBinder<>(
                R.layout.innermainrv_layout,
                InnerMainRv.class,
                (model, finder, payloads) -> finder
                        .setText(R.id.title, model.getNamaMerek())
                        .setImageDrawable(R.id.image_view, model.getImage())
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity().getApplicationContext(), QuestionnaireActivity.class);
                                Bundle extras = new Bundle();
                                extras.putInt("QUEST_SELECTED", model.getQuestId());
                                intent.putExtras(extras);
                                startActivity(intent);
                            }
                        })
        ));

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void showList(List<InnerMainRv> innerMainRvList) {
        adapter.setItems(innerMainRvList);
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
    public interface OnInnerMainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onInnerMainFragmentInteraction();
    }
}
