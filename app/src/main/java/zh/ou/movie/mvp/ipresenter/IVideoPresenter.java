package zh.ou.movie.mvp.ipresenter;

import zh.ou.movie.mvp.base.BasePresenter;

/**
 * author:   zhoux
 * date:    2017/8/28
 * email:   13617694689@163.com
 */

public interface IVideoPresenter extends BasePresenter{

    void getVideo(int movie_id);
}
