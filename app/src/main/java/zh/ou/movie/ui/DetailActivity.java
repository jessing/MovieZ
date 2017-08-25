package zh.ou.movie.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zh.ou.movie.R;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.ui.adapter.MoviePageAdapter;

import static zh.ou.movie.R.id.pager;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class DetailActivity extends AppCompatActivity{

    Unbinder unbinder;
    List<MovieResponse.ResultsBean>results = new ArrayList<>();
    @BindView(pager)
    ViewPager viewPager;
    MoviePageAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        unbinder = ButterKnife.bind(this);

        init();
    }

    private void init() {
        List<MovieResponse.ResultsBean>list = (List<MovieResponse.ResultsBean>) getIntent().getSerializableExtra("movie");
        final int position = getIntent().getIntExtra("pager_position",0);
        if(list != null){
            results.addAll(list);
            adapter = new MoviePageAdapter(getSupportFragmentManager(),results);
            viewPager.setAdapter(adapter);
            viewPager.setPageMargin((int) getResources().getDimension(R.dimen.card_padding) / 2);
            viewPager.setOffscreenPageLimit(3);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(position);
                }
            },300);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
    public void back(View view){
        onBackPressed();
    }
}
