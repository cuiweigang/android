package com.example.cuiweigang.gridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.navigation_item, new String[]{"name"}, new int[]{R.id.name});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Map<String, Object>> list = getData();
                Map<String, Object> m = list.get(position);
                Intent i = new Intent(getApplicationContext(), (Class<?>) m.get("active"));
                startActivity(i);
            }
        });

//        Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
//        System.out.println("########-main:id" + position);
//        i.putExtra("id", position);
//        startActivity(i);
//        final Button imageViewButton = (Button) findViewById(R.id.imageViewButton);
//        // 按钮点击事件
//        imageViewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), GridViewActivity.class);
//                startActivity(i);
//            }
//        });
//
//        final Button linerLayoutButton = (Button) findViewById(R.id.linearLayoutButton);
//        linerLayoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), LinearLayoutActivity.class);
//                startActivity(i);
//            }
//        });
//
//        final Button relativeLayoutButton = (Button) findViewById(R.id.relativeLayoutButton);
//        relativeLayoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), RelativeLayoutActivity.class);
//                startActivity(i);
//            }
//        });
//
//        final Button tableLayoutButton = (Button) findViewById(R.id.tableLayoutButton);
//        tableLayoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), TableLayoutActivity.class);
//                startActivity(i);
//            }
//        });
//
//        final Button listViewtButton = (Button) findViewById(R.id.listViewtButton);
//        listViewtButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), ListViewActivity.class);
//                startActivity(i);
//            }
//        });
    }

    HashMap<String, Object> navigationList = null;

    private List<Map<String, Object>> getData() {
        if (navigationList == null) {
            navigationList = new HashMap<>();
            navigationList.put("图片浏览", GridViewActivity.class);
            navigationList.put("LinearLayout", LinearLayoutActivity.class);
            navigationList.put("RelativeLayout", RelativeLayoutActivity.class);
            navigationList.put("TableLayout", TableLayoutActivity.class);
            navigationList.put("ListView", ListViewActivity.class);
            navigationList.put("ListView2", ListView2Activity.class);
        }

        List<Map<String, Object>> list = new ArrayList<>();
        for (String key : navigationList.keySet()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", key);
            map.put("active", navigationList.get(key));
            list.add(map);
        }

        return list;
    }
}




