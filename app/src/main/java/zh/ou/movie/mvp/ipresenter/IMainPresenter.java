package zh.ou.movie.mvp.ipresenter;

import zh.ou.movie.mvp.base.BasePresenter;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public interface IMainPresenter extends BasePresenter{

    void getPopular();
    void getTopRate();
    void getUpComing();

    void getConfiguration();

    void getGenres();
}
