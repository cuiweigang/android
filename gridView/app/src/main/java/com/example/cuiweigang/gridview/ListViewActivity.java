package com.example.cuiweigang.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(),
                R.layout.item,
                new String[]{"name", "phone", "amount"}
                , new int[]{R.id.name, R.id.phone, R.id.amount});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("##########" + position + "##:Id=" + id);
            }
        });

    }

    private List<Map<String, String>> getData() {

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            Map<String, String> map = new HashMap<>();
            map.put("name", "QQ" + Integer.toString(i));
            map.put("phone", Integer.toString(1366666666 + i));
            map.put("amount", Integer.toString(1000 + i));
            list.add(map);
        }

        return list;
    }

}
