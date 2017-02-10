package com.example.cuiweigang.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;


public class SingleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        System.out.println("########-singleViewActivity:id" + position);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.singleView);
        int image = gridViewAdapter.getImage(position);
        System.out.println("########-singleViewActivity:image" + image);
        imageView.setImageResource(image);

    }
}
