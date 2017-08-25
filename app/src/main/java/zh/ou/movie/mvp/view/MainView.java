package zh.ou.movie.mvp.view;

import java.util.List;

import zh.ou.movie.http.response.MovieResponse;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public interface MainView {
    void showProgress1();
    void showProgress2();
    void showProgress3();

    void hideProgress1();
    void hideProgress2();
    void hideProgress3();

    void showPopular(List<MovieResponse.ResultsBean>results);

    void showTopRate(List<MovieResponse.ResultsBean>results);

    void showUpComing(List<MovieResponse.ResultsBean>results);

    void showError1(String error);
    void showError2(String error);
    void showError3(String error);
    void showError4(String error);
}
