package zh.ou.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class TestActivity extends AppCompatActivity{
    @BindView(R.id.iv_test)
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        Glide.with(this)
                .load("https://ws1.sinaimg.cn/large/610dc034ly1fiuiw5givwj20u011h79a.jpg")
                .bitmapTransform(new RoundedCornersTransformation(this, 30, 0))
                .crossFade(1000)
                .placeholder(R.drawable.place_holder)
                .into(imageView);
    }
}
