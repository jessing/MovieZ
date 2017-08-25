package zh.ou.movie.http.interceptors;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import zh.ou.movie.C;
import zh.ou.movie.util.RequestUtility;

import static zh.ou.movie.util.StringUtils.getLanguage;

/**
 * Created by etiennelawlor on 12/5/16.
 */

public class AuthorizedNetworkInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain != null) {
            Request originalRequest = chain.request();
            Map<String, String> queryParamsMap = new HashMap<>();
           queryParamsMap.put("api_key", C.api_key);
            queryParamsMap.put("language", getLanguage());
            Request modifiedRequest = RequestUtility.addQueryParams(originalRequest, queryParamsMap);

            return chain.proceed(modifiedRequest);
        }

        return null;
    }
}
