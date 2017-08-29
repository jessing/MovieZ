package zh.ou.movie.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zh.ou.movie.App;
import zh.ou.movie.C;
import zh.ou.movie.R;
import zh.ou.movie.http.response.Genres;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.mvp.presenter.VideoPresenter;
import zh.ou.movie.mvp.view.VideoView;
import zh.ou.movie.util.MovieHubPrefs;
import zh.ou.movie.view.ProgressView;

import static android.app.Activity.RESULT_OK;
import static zh.ou.movie.util.StringUtils.getLanguage;
import static zh.ou.movie.util.StringUtils.getPosterUrl;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class DetailFragment extends Fragment implements VideoView {
    Unbinder unbinder;
    @BindView(R.id.pb_detail)
    ProgressBar pb;
    @BindView(R.id.iv_item_detail)
    SimpleDraweeView imageView;
    @BindView(R.id.tv_name_item_detail)
    TextView tvName;
    @BindView(R.id.tv_desc_item_detail)
    TextView tvDesc;
    @BindView(R.id.tv_type_item_detail)
    TextView tvType;
    @BindView(R.id.tv_release_item_detail)
    TextView tvRelease;
    @BindView(R.id.progress_item_detail)
    ProgressView progressView;
    @BindView(R.id.iv_play_detail)
    ImageView ivPlay;
    private MovieResponse.ResultsBean result;
    private VideoPresenter presenter;
    private Activity activity;
    private static final int REQ_START_STANDALONE_PLAYER = 1;
    private static final int REQ_RESOLVE_SERVICE_MISSING = 2;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public static DetailFragment newInstance(MovieResponse.ResultsBean result){
        DetailFragment  fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ResultsBean",result);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            result = (MovieResponse.ResultsBean) getArguments().getSerializable("ResultsBean");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail,container,false);
        unbinder = ButterKnife.bind(this,rootView);
        imageView.setImageURI(Uri.parse(getPosterUrl(result)));
        tvName.setText(result.getTitle());
        tvDesc.setText(result.getOverview());
        setType();
        tvRelease.setText(result.getRelease_date());
        progressView.setProgress((float) result.getVote_average());
        presenter = new VideoPresenter(this);
        return rootView;
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String type = (String) msg.obj;
            if(!TextUtils.isEmpty(type)){
                tvType.setText(type);
            }
        }
    };
    private void setType() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Genres genres;

                if(getLanguage().equals(C.language_zh)){
                    genres = MovieHubPrefs.getGenresZh(App.getContext());
                } else {
                    genres = MovieHubPrefs.getGenresEn(App.getContext());
                }
                if(genres == null){
                    return;
                }
                StringBuilder sb = new StringBuilder();
                outer:
                for(Integer id : result.getGenre_ids()){
                    for(Genres.GenresBean bean : genres.getGenres()){
                        if(bean.getId() == id){
                            sb.append(bean.getName()+" ");
                            continue outer;
                        }
                    }
                }
                String type ;
                if(sb.length() > 1){
                    type = sb.substring(0,sb.length()-1);
                    Message message = new Message();
                    message.what = 1001;
                    message.obj = type;
                    handler.sendMessage(message);
                }
            }
        }).start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.unSubscribe();
    }

    @Override
    public void showProgress() {
        pb.setVisibility(View.VISIBLE);
        ivPlay.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.GONE);
        ivPlay.setVisibility(View.VISIBLE);
    }

    @Override
    public void success(String key) {
//        Intent intent = new Intent(activity, FragmentDemoActivity.class);
//        intent.putExtra("movie_key",key);
//        activity.startActivity(intent);

        Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                activity, C.youtube_key, key, 0, true, false);
        if (canResolveIntent(intent)) {
            startActivityForResult(intent, REQ_START_STANDALONE_PLAYER);
        } else {
            // Could not resolve the intent - must need to install or update the YouTube API service.
            YouTubeInitializationResult.SERVICE_MISSING
                    .getErrorDialog(activity, REQ_RESOLVE_SERVICE_MISSING).show();
        }
    }
    private boolean canResolveIntent(Intent intent) {
        List<ResolveInfo> resolveInfo = activity.getPackageManager().queryIntentActivities(intent, 0);
        return resolveInfo != null && !resolveInfo.isEmpty();
    }
    @Override
    public void error(String error) {
        Toast.makeText(activity,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void empty() {
        Toast.makeText(activity,R.string.no_trailer,Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.iv_play_detail)
    void play(){
        presenter.getVideo(result.getId());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_START_STANDALONE_PLAYER && resultCode != RESULT_OK) {
            YouTubeInitializationResult errorReason =
                    YouTubeStandalonePlayer.getReturnedInitializationResult(data);
            if (errorReason.isUserRecoverableError()) {
                errorReason.getErrorDialog(activity, 0).show();
            } else {
                String errorMessage =
                        String.format(getString(R.string.error_player), errorReason.toString());
                Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show();
            }
        }
    }
}
