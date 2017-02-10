package com.example.cuiweigang.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.cuiweigang.gridview.R;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private int[] imageId = new int[]{R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04, R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08, R.drawable.img09, R.drawable.img10, R.drawable.img11, R.drawable.img12};

    public GridViewAdapter(Context c) {
        this.context = c;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageId[position]);
        return imageView;
    }

    public int getImage(int position) {
        if (imageId.length > position && position >= 0) {
            return imageId[position];
        }

        return 0;

    }
}