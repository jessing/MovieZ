package zh.ou.movie.util;

import java.util.List;
import java.util.Locale;

import zh.ou.movie.App;
import zh.ou.movie.C;
import zh.ou.movie.http.response.Configuration;
import zh.ou.movie.http.response.Images;
import zh.ou.movie.http.response.MovieResponse;

import static zh.ou.movie.App.getContext;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class StringUtils {
    public static String getPosterUrl(MovieResponse.ResultsBean result){
        String posterUrl = "";
        Configuration configuration = MovieHubPrefs.getConfiguration(getContext());
        if(configuration != null) {
            Images images = configuration.getImages();
            if (images != null) {

                List<String> posterSizes = images.getPosterSizes();
                if (posterSizes != null && posterSizes.size() > 0) {
                    String posterSize;
                    if (posterSizes.size() > 1) {
                        posterSize = posterSizes.get(posterSizes.size() - 2);
                    } else {
                        posterSize = posterSizes.get(posterSizes.size() - 1);
                    }

                    String secureBaseUrl = images.getSecureBaseUrl();
                    String posterPath = result.getPoster_path();

                    posterUrl = String.format("%s%s%s", secureBaseUrl, posterSize, posterPath);
                }
            }
        }
        return posterUrl;
    }
    public static String getLanguage(){
        Locale locale = App.getContext().getResources().getConfiguration().locale;
        if(locale.getLanguage().equals("zh")){
            return C.language_zh;
        }
        return C.language_en;
    }
}
