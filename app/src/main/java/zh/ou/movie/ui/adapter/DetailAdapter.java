package zh.ou.movie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zh.ou.movie.R;
import zh.ou.movie.http.response.MovieResponse;
import zh.ou.movie.view.ProgressView;

import static zh.ou.movie.util.StringUtils.getPosterUrl;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder>{

    private Context context;
    private List<MovieResponse.ResultsBean>results;

    public DetailAdapter(Context context, List<MovieResponse.ResultsBean> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public DetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailHolder(View.inflate(context, R.layout.item_detail,null));
    }

    @Override
    public void onBindViewHolder(DetailHolder holder, int position) {
        MovieResponse.ResultsBean result = results.get(position);

        Glide.with(context).load(getPosterUrl(result)).asBitmap().placeholder(R.drawable.place_holder).into(holder.imageView);

        holder.tvName.setText(result.getTitle());
//        holder.tvDesc.setText(result.getOverview());
        holder.tvType.setText(result.getGenre_ids().toString());
        holder.progressView.setProgress((float) result.getVote_average());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class DetailHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_item_detail)
        ImageView imageView;
        @BindView(R.id.tv_name_item_detail)
        TextView tvName;
        @BindView(R.id.tv_desc_item_detail)
        TextView tvDesc;
        @BindView(R.id.tv_type_item_detail)
        TextView tvType;
        @BindView(R.id.progress_item_detail)
        ProgressView progressView;
        public DetailHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
