package zh.ou.movie;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.File;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class App extends Application {

    private static Context context;
    private static App currentApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        currentApplication = this;
        Fresco.initialize(this);
    }
    public static Context getContext(){
        return context;
    }
    public static File getCacheDirectory() {
        return currentApplication.getCacheDir();
    }
}
