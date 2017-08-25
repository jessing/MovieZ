package zh.ou.movie.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zh.ou.movie.R;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.ui.DetailActivity;
import zh.ou.movie.util.ShareElement;

import static zh.ou.movie.util.StringUtils.getPosterUrl;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder>{

    private List<MovieResponse.ResultsBean>results;
    private Context context;
    public MovieAdapter(Context context,List<MovieResponse.ResultsBean> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(context,R.layout.item_movie,null));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        MovieResponse.ResultsBean result = results.get(position);
        holder.imageView.setImageURI(Uri.parse(getPosterUrl(result)));
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(30f);
        holder.imageView.getHierarchy().setRoundingParams(roundingParams);
        holder.imageView.getHierarchy().setPlaceholderImage(R.drawable.place_holder);
        holder.imageView.getHierarchy().setFadeDuration(300);
        holder.textView.setText(result.getTitle());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item_movie)
        SimpleDraweeView imageView;
        @BindView(R.id.tv_item_movie)
        TextView textView;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @OnClick(R.id.iv_item_movie)
        void onclick(){
            ShareElement.shareDrawable = imageView.getDrawable();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("movie", (Serializable) results);
            intent.putExtra("pager_position",position);
            context.startActivity(intent);
        }
        int position;
    }
}
