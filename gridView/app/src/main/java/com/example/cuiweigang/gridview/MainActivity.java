package com.example.cuiweigang.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.content.Context;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
//        System.out.println("########-main:id" + position);
//        i.putExtra("id", position);
//        startActivity(i);
        final Button imageViewButton = (Button) findViewById(R.id.imageViewButton);
        // 按钮点击事件
        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GridViewActivity.class);
                startActivity(i);
            }
        });

        final Button linerLayoutButton = (Button) findViewById(R.id.linearLayoutButton);
        linerLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LinearLayoutActivity.class);
                startActivity(i);
            }
        });

        final Button relativeLayoutButton = (Button) findViewById(R.id.relativeLayoutButton);
        relativeLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RelativeLayoutActivity.class);
                startActivity(i);
            }
        });
    }
}




