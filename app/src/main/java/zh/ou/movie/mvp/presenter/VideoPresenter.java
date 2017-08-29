package zh.ou.movie.mvp.presenter;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zh.ou.movie.C;
import zh.ou.movie.http.MovieService;
import zh.ou.movie.http.ServiceGenerator;
import zh.ou.movie.http.response.VideoResponse;
import zh.ou.movie.mvp.ipresenter.IVideoPresenter;
import zh.ou.movie.mvp.view.VideoView;

/**
 * author:   zhoux
 * date:    2017/8/28
 * email:   13617694689@163.com
 */

public class VideoPresenter implements IVideoPresenter{
    private VideoView videoView;
    private Subscription subscription;

    public VideoPresenter(VideoView videoView) {
        this.videoView = videoView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void getVideo(int movie_id) {
        videoView.showProgress();
        subscription = ServiceGenerator.createService(MovieService.class)
                .getVideos(movie_id, C.api_key,C.language_en)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        videoView.hideProgress();
                        videoView.error(e.getMessage());
                    }

                    @Override
                    public void onNext(VideoResponse videoResponse) {
                        videoView.hideProgress();
                        if(videoResponse != null && videoResponse.getResults() != null && videoResponse.getResults().size()>0){
                            List<VideoResponse.ResultsBean> list = videoResponse.getResults();
                            for(VideoResponse.ResultsBean bean : list){
                                if(bean.getType().equals("Trailer")){
                                    videoView.success(bean.getKey());
                                    return;
                                }
                            }
                            videoView.empty();
                        } else {
                            videoView.empty();
                        }
                    }
                });
    }
}
