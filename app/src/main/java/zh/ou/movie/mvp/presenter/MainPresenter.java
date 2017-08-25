package zh.ou.movie.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zh.ou.movie.App;
import zh.ou.movie.C;
import zh.ou.movie.http.MovieService;
import zh.ou.movie.http.ServiceGenerator;
import zh.ou.movie.http.interceptors.AuthorizedNetworkInterceptor;
import zh.ou.movie.http.response.Configuration;
import zh.ou.movie.http.response.Genres;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.mvp.ipresenter.IMainPresenter;
import zh.ou.movie.mvp.view.MainView;
import zh.ou.movie.util.MovieHubPrefs;

import static zh.ou.movie.util.StringUtils.getLanguage;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class MainPresenter implements IMainPresenter{
    private MainView mainView;

    private Subscription subscription1;
    private Subscription subscription2;
    private Subscription subscription3;
    private Subscription subscription4;
    private Subscription subscription5;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void subscribe() {
        getGenres();
        if(MovieHubPrefs.getConfiguration(App.getContext()) == null){
            getConfiguration();
        } else {
            getPopular();
            getTopRate();
            getUpComing();
        }
    }

    @Override
    public void unSubscribe() {
        if(subscription1 != null && !subscription1.isUnsubscribed()){
            subscription1.unsubscribe();
        }
        if(subscription2 != null && !subscription2.isUnsubscribed()){
            subscription2.unsubscribe();
        }
        if(subscription3 != null && !subscription3.isUnsubscribed()){
            subscription3.unsubscribe();
        }
        if(subscription4 != null && !subscription4.isUnsubscribed()){
            subscription4.unsubscribe();
        }
        if(subscription5 != null && !subscription5.isUnsubscribed()){
            subscription5.unsubscribe();
        }
    }


    @Override
    public void getPopular() {
        mainView.showProgress1();
        subscription1 = ServiceGenerator.createService(MovieService.class,new AuthorizedNetworkInterceptor())
                .getPopular(1)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<MovieResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mainView.hideProgress1();
                mainView.showError1(e.getMessage());
            }

            @Override
            public void onNext(MovieResponse movieResponse) {
                mainView.hideProgress1();
                if(movieResponse != null && movieResponse.getResults() != null){
                    if(movieResponse.getResults().size() > 0){
                        mainView.showPopular(movieResponse.getResults());
                    } else {
                        mainView.showError1("there is no movies");
                    }
                } else {
                    mainView.showError1("get movies fail");
                }
            }
        });
    }

    @Override
    public void getTopRate() {
        mainView.showProgress3();
        subscription2 = ServiceGenerator.createService(MovieService.class,new AuthorizedNetworkInterceptor())
                .getTopRate(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mainView.hideProgress3();
                        mainView.showError3(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieResponse movieResponse) {
                        mainView.hideProgress3();
                        if(movieResponse != null && movieResponse.getResults() != null){
                            if(movieResponse.getResults().size() > 0){
                                mainView.showTopRate(movieResponse.getResults());
                            } else {
                                mainView.showError3("there is no movies");
                            }
                        } else {
                            mainView.showError3("get movies fail");
                        }
                    }
                });
    }

    @Override
    public void getUpComing() {
        mainView.showProgress2();
        subscription3 = ServiceGenerator.createService(MovieService.class,new AuthorizedNetworkInterceptor())
                .getUpComing(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mainView.hideProgress2();
                        mainView.showError2(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieResponse movieResponse) {
                        mainView.hideProgress2();
                        if(movieResponse != null && movieResponse.getResults() != null){
                            if(movieResponse.getResults().size() > 0){
                                mainView.showUpComing(movieResponse.getResults());
                            } else {
                                mainView.showError2("there is no movies");
                            }
                        } else {
                            mainView.showError2("get movies fail");
                        }
                    }
                });
    }

    @Override
    public void getConfiguration() {
        subscription4 = ServiceGenerator.createService(MovieService.class,new AuthorizedNetworkInterceptor())
                .getConfiguration()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Configuration>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Configuration configuration) {
                        if(configuration != null){
                            MovieHubPrefs.setConfiguration(App.getContext(),configuration);
                            getPopular();
                            getTopRate();
                            getUpComing();
                        } else {
                            mainView.showError4("get configuration fail");
                        }
                    }
                });
//        Call<Configuration>call =  ServiceGenerator.createService(MovieService.class,new AuthorizedNetworkInterceptor())
//                .getConfiguration();
//        call.enqueue(new Callback<Configuration>() {
//            @Override
//            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
//                Configuration configuration = response.body();
//                if(configuration != null){
//                    MovieHubPrefs.setConfiguration(App.getContext(),configuration);
//                    getPopular();
//                    getTopRate();
//                    getUpComing();
//                } else {
//                    mainView.hideProgress();
//                    mainView.showError("get configuration fail");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Configuration> call, Throwable t) {
//                t.printStackTrace();
//                mainView.hideProgress();
//                mainView.showError(t.getMessage());
//            }
//        });
    }

    @Override
    public void getGenres() {
        if(getLanguage().equals(C.language_zh)){
            if(MovieHubPrefs.getGenresZh(App.getContext()) == null){
                subscription5 = ServiceGenerator.createService(MovieService.class,
                        new AuthorizedNetworkInterceptor())
                        .getGenres()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Genres>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Genres genres) {
                                if(genres != null){
                                    MovieHubPrefs.setGenresZh(App.getContext(),genres);
                                }
                            }
                        });
            }
        } else {
            if(MovieHubPrefs.getGenresEn(App.getContext()) == null){
                subscription5 = ServiceGenerator.createService(MovieService.class,
                        new AuthorizedNetworkInterceptor())
                        .getGenres()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Genres>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Genres genres) {
                                if(genres != null){
                                    MovieHubPrefs.setGenresEn(App.getContext(),genres);
                                }
                            }
                        });
            }
        }

    }
}
