package walden.com.pictureprocessingtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class FlagImageView extends ImageView {

    private float k = 0;
    private Bitmap bitmap;
    int WIDTH = 100;
    int HEIGHT = 100;
    float[] verts;
    float[] orig;
    int A = 1;

    public FlagImageView(Context context) {
        super(context);
        init();
    }

    public FlagImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlagImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        flagWavw();
        k += 0.1f;
        canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);

        postInvalidateDelayed(5);
    }

    private void init() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_1);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        verts = new float[bitmapWidth * bitmapHeight];
        orig = new float[bitmapWidth * bitmapHeight];
        int index = 0;
        for (int y = 0; y < HEIGHT; y++) {
            float fy = bitmapHeight * y / HEIGHT;
            for (int x = 0; x < WIDTH; x++) {
                float fx = bitmapWidth * x / WIDTH;
                orig[index * 2] = verts[index * 2] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy + 100;
                index++;
            }
        }
        Log.d("asd", "init: ");
    }

    private void flagWavw() {
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
                verts[(j * (WIDTH + 1) + i) * 2] += 0;
                float offsetY = (float) Math.sin((float) i / WIDTH * 2 * Math.PI * k);
                verts[(j * (WIDTH + 1) + i) * 2 + 1] = orig[(j * WIDTH + i) * 2 + 1] + offsetY * A;
            }
        }
    }
}
