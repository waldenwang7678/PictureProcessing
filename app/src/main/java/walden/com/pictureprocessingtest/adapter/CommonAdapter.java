package walden.com.pictureprocessingtest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import walden.com.pictureprocessingtest.R;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class CommonAdapter extends BaseAdapter {
    private ArrayList<String> mData;
    private Context mContext;

    public CommonAdapter(Context context, ArrayList<String> data) {
        mContext = context;
        mData = data;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.griditem, null);

        TextView textView = (TextView) view.findViewById(R.id.grid_str);
        if (mData != null && mData.size() > 0) {
            textView.setText(mData.get(position));
        }
        return view;
    }
}
