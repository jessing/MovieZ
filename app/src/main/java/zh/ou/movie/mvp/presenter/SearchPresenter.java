package zh.ou.movie.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zh.ou.movie.http.MovieService;
import zh.ou.movie.http.ServiceGenerator;
import zh.ou.movie.http.interceptors.AuthorizedNetworkInterceptor;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.mvp.ipresenter.ISearchPresenter;
import zh.ou.movie.mvp.view.SearchView;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class SearchPresenter implements ISearchPresenter{
    private SearchView searchView;
    private Subscription subscription;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
    }

    @Override
    public void search(String query) {
        searchView.showProgress();
        subscription = ServiceGenerator.createService(MovieService.class,new AuthorizedNetworkInterceptor())
                .searchMovie(1,query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        searchView.hideProgress();
                        searchView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieResponse movieResponse) {
                        searchView.hideProgress();
                        if(movieResponse != null){
                             if(movieResponse.getResults() != null){
                                 if(movieResponse.getResults().size() > 0){
                                     searchView.success(movieResponse.getResults());
                                 } else {
                                     searchView.showEmpty();
                                 }
                             } else {
                                 searchView.showError("fail to search anything");
                             }
                        } else {
                            searchView.showError("fail to search anything");
                        }
                    }
                });
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
}
