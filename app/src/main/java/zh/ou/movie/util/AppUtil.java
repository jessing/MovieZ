package zh.ou.movie.util;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import zh.ou.movie.R;

/**
 * author:   zhoux
 * date:    2017/8/28
 * email:   13617694689@163.com
 */

public class AppUtil {
    public static void showAbout(Activity activity){
        new AlertDialog.Builder(activity)
                .setTitle(R.string.about)
                .setMessage(R.string.desc_app)
                .show();
    }
}
