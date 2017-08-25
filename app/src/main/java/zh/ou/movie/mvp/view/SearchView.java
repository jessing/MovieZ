package zh.ou.movie.mvp.view;

import java.util.List;

import zh.ou.movie.http.response.MovieResponse;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public interface SearchView {

    void showProgress();

    void hideProgress();

    void success(List<MovieResponse.ResultsBean>results);

    void showError(String error);

    void showEmpty();
}
