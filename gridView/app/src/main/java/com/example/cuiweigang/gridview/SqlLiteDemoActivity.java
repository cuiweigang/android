package com.example.cuiweigang.gridview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SqlLiteDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite_demo);

        SQLiteDatabase db = openOrCreateDatabase("data.db", MODE_PRIVATE, null);

        db.execSQL("create table if not exists users(_id integer primary key autoincrement,name text null,age Integer,address text null)");
        db.execSQL("delete from users");
        db.execSQL("insert into users(name,age,address) values('小王',10,'北京市朝阳区')");
        db.execSQL("insert into users(name,age,address) values('小明',22,'北京市通州区')");
        db.execSQL("insert into users(name,age,address) values('小李',24,'北京市海淀区')");

        Cursor rows = db.rawQuery("select * from users", null);

        if (rows != null) {
            Log.i("info", "总共有" + rows.getCount() + "行数据");
            while (rows.moveToNext()) { //　数据移动到下一条
                Log.i("info", "_id:" + rows.getInt(rows.getColumnIndex("_id")));//获取_id列数据
                Log.i("info", "name:" + rows.getString(rows.getColumnIndex("name")));//获取name列数据
                Log.i("info", "address:" + rows.getString(rows.getColumnIndex("address"))); //获取address列数据
                Log.i("info", "#############");
            }
            rows.close(); //关闭游标
        }
        db.close(); //关闭数据库


        //System.out.println(rows.get);
    }
}
