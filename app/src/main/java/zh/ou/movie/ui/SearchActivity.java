package zh.ou.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zh.ou.movie.R;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.mvp.presenter.SearchPresenter;
import zh.ou.movie.mvp.view.SearchView;
import zh.ou.movie.ui.adapter.MovieAdapter;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class SearchActivity extends AppCompatActivity implements SearchView{
    Unbinder unbinder;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycler_search)
    RecyclerView recyclerView;
    @BindView(R.id.pb_search)
    ProgressBar pb;
    @BindView(R.id.tv_empty_search)
    TextView tvEmpty;

    private MovieAdapter adapter;
    private SearchPresenter searchPresenter;
    private List<MovieResponse.ResultsBean>results = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        unbinder = ButterKnife.bind(this);
        searchPresenter = new SearchPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MovieAdapter(this,results);
        recyclerView.setAdapter(adapter);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i == 0 || i == 3) && keyEvent != null) {
                    hideSoftKeyboard(etSearch);
                    tvEmpty.setText("");
                    tvEmpty.setVisibility(View.GONE);
                    searchPresenter.search(etSearch.getText().toString().trim());
                    return true;
                }
                return false;
            }
        });
    }
    public void back(View view){
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showProgress() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void success(List<MovieResponse.ResultsBean> results) {
        this.results.clear();
        this.results.addAll(results);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        tvEmpty.setVisibility(View.VISIBLE);
        tvEmpty.setText(error);
    }

    @Override
    public void showEmpty() {
        tvEmpty.setVisibility(View.VISIBLE);
        tvEmpty.setText("can not search anything");
    }
    public void hideSoftKeyboard(View view) {
        if (view == null) return;

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        view.clearFocus();
    }
}
