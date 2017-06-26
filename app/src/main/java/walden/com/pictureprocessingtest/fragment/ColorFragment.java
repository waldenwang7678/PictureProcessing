package walden.com.pictureprocessingtest.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import walden.com.pictureprocessingtest.R;
import walden.com.pictureprocessingtest.adapter.CommonAdapter;
import walden.com.pictureprocessingtest.utils.FloatStorage;
import walden.com.pictureprocessingtest.utils.ImageHelper;


/**
 * ColorMatrix， 可以使用4x5的矩阵改变图像颜色信息
 */
public class ColorFragment extends Fragment {

    private GridView gridView;
    private ArrayList<String> mData = new ArrayList<>();
    private ImageView imageView;
    private int mColor = 255;
    private int mLight = 15;
    private int mSaturability = 1;
    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initData();
        View view = inflater.inflate(R.layout.color_fragment_layout, null);
        imageView = (ImageView) view.findViewById(R.id.color_iv);
        gridView = (GridView) view.findViewById(R.id.color_gv);
        CommonAdapter adapter = new CommonAdapter(getActivity(), mData);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dealImage(position);
            }
        });
        return view;
    }

    private void initData() {
        mData.add("原图");
        mData.add("色调+");
        mData.add("亮度+");
        mData.add("饱和度+");
        mData.add("灰度");
        mData.add("反转");
        mData.add("怀旧");
        mData.add("去色");
        mData.add("高饱和");
    }

    private void dealImage(int position) {
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_1);
        }
        switch (position) {
            case 0:
                imageView.setImageResource(R.drawable.img_1);
                break;
            case 1:    //色调
                setColor();
                break;
            case 2:   //亮度
                setLight();
                break;
            case 3:  //饱和度
                setSaturability();
                break;
            case 4:  //灰色
                setImage(FloatStorage.greyMatrix);
                break;
            case 5:  //反转
                setImage(FloatStorage.reverseMatrix);
                break;
            case 6:  //怀旧
                setImage(FloatStorage.oldMatrix);
                break;
            case 7:  //去色
                setImage(FloatStorage.dropColorMatrix);
                break;
            case 8:  //高饱和
                setImage(FloatStorage.highSaturation);
                break;
        }
    }

    private void setColor() {
        mColor -= 10;
        if (mColor <= 0) {
            mColor = 255;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setRotate(0, mColor);
        colorMatrix.setRotate(1, mColor);
        colorMatrix.setRotate(2, mColor);
        imageView.setImageBitmap(ImageHelper.handleImageByColorMatrix(bitmap, colorMatrix));
    }

    private void setLight() {
        mLight -= 1;
        if (mLight <= -10) {
            mLight = 15;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(mLight);
        imageView.setImageBitmap(ImageHelper.handleImageByColorMatrix(bitmap, colorMatrix));
    }

    private void setSaturability() {
        mSaturability += 1;
        if (mSaturability > 20) {
            mSaturability = 1;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(mSaturability, mSaturability, mSaturability, 1);
        imageView.setImageBitmap(ImageHelper.handleImageByColorMatrix(bitmap, colorMatrix));
    }

    private void setImage(float[] f) {
        imageView.setImageBitmap(ImageHelper.hanleImageByMatrixFloat(bitmap, f));
    }
}
