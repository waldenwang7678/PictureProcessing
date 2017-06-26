package walden.com.pictureprocessingtest.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import walden.com.pictureprocessingtest.FlagImageView;
import walden.com.pictureprocessingtest.R;
import walden.com.pictureprocessingtest.adapter.CommonAdapter;
import walden.com.pictureprocessingtest.utils.ImageHelper;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class ImageFragment extends Fragment {

    private ImageView iv;
    private FlagImageView iv1;
    private ListView list;
    private ArrayList mData = new ArrayList<>();
    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_layout, null);
        initData();
        list = (ListView) view.findViewById(R.id.image_list);
        iv = (ImageView) view.findViewById(R.id.image_iv);
        iv1 = (FlagImageView) view.findViewById(R.id.image_iv1);
        CommonAdapter adapter = new CommonAdapter(getActivity(), mData);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dealImage(position);
            }
        });
        return view;

    }

    private void dealImage(int position) {
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_1);
        }
        iv.setVisibility(View.VISIBLE);
        iv1.setVisibility(View.GONE);
        switch (position) {
            case 0:
                iv.setImageResource(R.drawable.img_1);
                break;
            case 1:
                Matrix matrix1 = new Matrix();
                matrix1.setRotate(45, bitmap.getWidth() / 2, bitmap.getHeight() / 2);    //角度， 旋转中心
                iv.setImageBitmap(ImageHelper.handleImageByMatrix(bitmap, matrix1));
                break;
            case 2:
                Matrix matrix2 = new Matrix();   //右下角不变
                matrix2.setTranslate(200, 200);
                iv.setImageBitmap(ImageHelper.handleImageByMatrix(bitmap, matrix2));
                break;
            case 3:
                Matrix matrix3 = new Matrix();   //缩放 ， 左上角开始 x ,y 变化倍数
                matrix3.setScale(0.5f, 1);
                iv.setImageBitmap(ImageHelper.handleImageByMatrix(bitmap, matrix3));
                break;
            case 4:
                Matrix matrix4 = new Matrix();   //错切
                matrix4.setSkew(0.2f, 0.1f);
                iv.setImageBitmap(ImageHelper.handleImageByMatrix(bitmap, matrix4));
                break;
            case 5:
                iv.setVisibility(View.GONE);
                iv1.setVisibility(View.VISIBLE);


                break;
        }
    }

    private void initData() {
        mData.add("原图");
        mData.add("旋转");
        mData.add("移动");
        mData.add("缩放");
        mData.add("错切");
        mData.add("扭曲");
    }
}
