package zh.ou.movie.http;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import zh.ou.movie.http.response.Configuration;
import zh.ou.movie.http.response.Genres;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.http.response.VideoResponse;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public interface MovieService {

    @GET("movie/popular")
    Observable<MovieResponse> getPopular(@Query("page")int page);

    @GET("movie/upcoming")
    Observable<MovieResponse> getUpComing(@Query("page")int page);

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRate(@Query("page")int page);

    @GET("search/movie")
    Observable<MovieResponse> searchMovie(@Query("page")int page, @Query("query")String query);

    @GET("configuration")
    Observable<Configuration> getConfiguration();

    @GET("genre/movie/list")
    Observable<Genres> getGenres();

    @GET("movie/{movie_id}/videos")
    Observable<VideoResponse>getVideos(@Path("movie_id")int movie_id,
                                       @Query("api_key")String api_key,
                                       @Query("language")String language);
}
