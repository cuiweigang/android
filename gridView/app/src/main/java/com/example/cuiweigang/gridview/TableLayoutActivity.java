package com.example.cuiweigang.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        Button button = (Button) findViewById(R.id.backButton);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TableLayoutActivity.this.finish(); //返回上一页
                    //onKeyDown(KeyEvent.KEYCODE_BACK, null);
                }
            });
        }

    }
}
