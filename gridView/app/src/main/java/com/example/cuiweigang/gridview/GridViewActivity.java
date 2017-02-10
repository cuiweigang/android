package com.example.cuiweigang.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this);
        gridView.setAdapter(gridViewAdapter);

        // 为GridViewItem设定点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
                System.out.println("########-main:id" + position);
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}
