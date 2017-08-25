package zh.ou.movie.ui.fragment;

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
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zh.ou.movie.App;
import zh.ou.movie.C;
import zh.ou.movie.R;
import zh.ou.movie.http.response.Genres;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.util.MovieHubPrefs;
import zh.ou.movie.view.ProgressView;

import static zh.ou.movie.util.StringUtils.getLanguage;
import static zh.ou.movie.util.StringUtils.getPosterUrl;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class DetailFragment extends Fragment{
    Unbinder unbinder;
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
    private MovieResponse.ResultsBean result;
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
    }
}
