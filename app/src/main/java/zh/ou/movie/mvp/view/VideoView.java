package zh.ou.movie.mvp.view;

/**
 * author:   zhoux
 * date:    2017/8/28
 * email:   13617694689@163.com
 */

public interface VideoView {
    void showProgress();

    void hideProgress();

    void success(String key);

    void error(String error);

    void empty();
}
