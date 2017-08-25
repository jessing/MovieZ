package zh.ou.movie.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class ProgressView extends View{
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Context context;
    private float mProgress;
    public ProgressView(Context context) {
        super(context);
        init(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        this.context = context;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        Shader shader = new LinearGradient(0,0,getWidth(),0,new int[]{0xaab2fc95,0xaa8bfaf9},null,
                Shader.TileMode.REPEAT);
        paint.setShader(shader);
        int center = getWidth()/2;

        canvas.drawArc(10,10,getWidth()-10,getHeight()-10,-90,mProgress * 360 / 10,false,paint);

        Paint textPaint = new Paint();
        textPaint.setShader(shader);
        textPaint.setTextSize(40);
        canvas.drawText(mProgress+"",getWidth()/2-30,getHeight()/2+20,textPaint);
    }
    public void setProgress(float progress){
        this.mProgress = progress;
        this.invalidate();
    }
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
