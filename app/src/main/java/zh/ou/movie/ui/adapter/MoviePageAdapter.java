package zh.ou.movie.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.ui.fragment.DetailFragment;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class MoviePageAdapter extends FragmentPagerAdapter{
    private List<MovieResponse.ResultsBean>resultsBeen;

    public MoviePageAdapter(FragmentManager fm, List<MovieResponse.ResultsBean> resultsBeen) {
        super(fm);
        this.resultsBeen = resultsBeen;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailFragment.newInstance(resultsBeen.get(position));
    }

    @Override
    public int getCount() {
        return resultsBeen.size();
    }
}
