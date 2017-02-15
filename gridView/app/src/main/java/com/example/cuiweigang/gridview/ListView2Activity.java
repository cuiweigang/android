package com.example.cuiweigang.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class ListView2Activity extends AppCompatActivity {

    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private ListView list_content;
    private ArrayList<Object> mData = null;
    private MutiLayoutAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        //数据准备：
        mData = new ArrayList<Object>();
        for (int i = 0; i < 20; i++) {
            switch ((int) (Math.random() * 2)) {
                case TYPE_BOOK:
                    mData.add(new Book("《第一行代码》", "郭霖"));
                    break;
                case TYPE_APP:
                    mData.add(new App(R.drawable.iv_icon_baidu, "百度"));
                    break;
            }
        }

        list_content = (ListView) findViewById(R.id.list_content);
        myAdapter = new MutiLayoutAdapter(ListView2Activity.this, mData);
        list_content.setAdapter(myAdapter);
    }
}
