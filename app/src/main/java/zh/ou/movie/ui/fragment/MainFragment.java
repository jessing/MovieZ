package zh.ou.movie.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zh.ou.movie.R;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.mvp.presenter.MainPresenter;
import zh.ou.movie.mvp.view.MainView;
import zh.ou.movie.ui.adapter.MovieAdapter;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class MainFragment extends Fragment implements MainView{
    Unbinder unbinder;
    private Activity activity;
    private MainPresenter mainPresenter;
    @BindView(R.id.recycler_popular)
    RecyclerView recyclerViewPopular;
    @BindView(R.id.recycler_coming)
    RecyclerView recyclerViewUpComing;
    @BindView(R.id.recycler_top_rate)
    RecyclerView recyclerViewTopRate;
    @BindView(R.id.pb1)
    ProgressBar pb1;
    @BindView(R.id.pb2)
    ProgressBar pb2;
    @BindView(R.id.pb3)
    ProgressBar pb3;
    @BindView(R.id.error1)
    TextView error1;
    @BindView(R.id.error2)
    TextView error2;
    @BindView(R.id.error3)
    TextView error3;
    MovieAdapter adapter1;
    MovieAdapter adapter2;
    MovieAdapter adapter3;
    List<MovieResponse.ResultsBean> listPopular = new ArrayList<>();
    List<MovieResponse.ResultsBean> listComing = new ArrayList<>();
    List<MovieResponse.ResultsBean> listTopRate = new ArrayList<>();
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = View.inflate(activity,R.layout.fragment_main,null);
        unbinder = ButterKnife.bind(this,rootView);

        init();

        return rootView;
    }

    private void init() {


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopular.setLayoutManager(linearLayoutManager1);
        recyclerViewUpComing.setLayoutManager(linearLayoutManager2);
        recyclerViewTopRate.setLayoutManager(linearLayoutManager3);
        mainPresenter = new MainPresenter(this);
        mainPresenter.subscribe();
    }


    @Override
    public void showProgress1() {
        pb1.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress2() {
        pb2.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress3() {
        pb3.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress1() {
        pb1.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress2() {
        pb2.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress3() {
        pb3.setVisibility(View.GONE);
    }

    @Override
    public void showPopular(List<MovieResponse.ResultsBean> results) {
        listPopular.addAll(results);
        adapter1 = new MovieAdapter(activity,listPopular);
        recyclerViewPopular.setAdapter(adapter1);
    }

    @Override
    public void showTopRate(List<MovieResponse.ResultsBean> results) {
        listTopRate.addAll(results);
        adapter3 = new MovieAdapter(activity,listTopRate);
        recyclerViewTopRate.setAdapter(adapter3);

    }

    @Override
    public void showUpComing(List<MovieResponse.ResultsBean> results) {
        listComing.addAll(results);
        adapter2 = new MovieAdapter(activity,listComing);
        recyclerViewUpComing.setAdapter(adapter2);
    }

    @Override
    public void showError1(String error) {
        error1.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError2(String error) {
        error2.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError3(String error) {
        error3.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError4(String error) {
        Toast.makeText(activity,error,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public void error1(View view){
        mainPresenter.getPopular();
    }
    public void error2(View view){
        mainPresenter.getUpComing();
    }
    public void error3(View view){
        mainPresenter.getTopRate();
    }
}
