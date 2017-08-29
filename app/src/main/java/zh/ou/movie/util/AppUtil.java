package zh.ou.movie.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import zh.ou.movie.C;
import zh.ou.movie.R;

/**
 * author:   zhoux
 * date:    2017/8/28
 * email:   13617694689@163.com
 */

public class AppUtil {
    public static void showAbout(final Activity activity){
        new MaterialDialog.Builder(activity)
                .title(R.string.about)
                .content(R.string.desc_app)
                .positiveText(R.string.rate)
                .negativeText(R.string.share)
                .backgroundColorRes(R.color.colorPrimary)
                .contentColorRes(android.R.color.white)
                .titleColorRes(android.R.color.white)
                .positiveColorRes(android.R.color.white)
                .negativeColorRes(android.R.color.white)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        launchAppDetail(activity,getAppPackage(activity));
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        String text = String.format(activity.getString(R.string.share_text),
                                C.google_play_url,
                                getAppName(activity));
                        Intent textIntent = new Intent(Intent.ACTION_SEND);
                        textIntent.setType("text/plain");
                        textIntent.putExtra(Intent.EXTRA_SUBJECT,getAppName(activity));
                        textIntent.putExtra(Intent.EXTRA_TEXT, text);
                        activity.startActivity(Intent.createChooser(textIntent,activity.getString(R.string.share_subject)));
                    }
                })
                .show();
    }
    public static String getAppName(Context context){
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void launchAppDetail(Context context,String appPkg) {
        try {
            if (TextUtils.isEmpty(appPkg)) return;

            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getAppPackage(Context context){
        return context.getPackageName();
    }
}
