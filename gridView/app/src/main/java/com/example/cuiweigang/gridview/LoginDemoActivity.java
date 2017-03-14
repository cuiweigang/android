package com.example.cuiweigang.gridview;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginDemoActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_demo);

        sharedPreferences = getSharedPreferences("LoginInfo", MODE_PRIVATE);
        final EditText useNameEditText = (EditText) findViewById(R.id.userName_editText);
        final EditText passwordEditText = (EditText) findViewById(R.id.password_text);
        final CheckBox savePasswordCheckBox = (CheckBox) findViewById(R.id.savePassword);
        final TextView loginMessageTextView = (TextView) findViewById(R.id.loginMessage);

        // 初始化状态值
        String userName = sharedPreferences.getString("userName", "");
        String password = sharedPreferences.getString("password", "");
        boolean isChecked = sharedPreferences.getBoolean("isChecked", false);
        useNameEditText.setText(userName);
        passwordEditText.setText(password);
        savePasswordCheckBox.setChecked(isChecked);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = useNameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if ("cui".equals(username) && "111".equals(password)) {

                    SharedPreferences.Editor editer = sharedPreferences.edit();
                    System.out.println("是否选中" + savePasswordCheckBox.isChecked());
                    if (savePasswordCheckBox.isChecked()) {
                        editer.putString("userName", username);
                        editer.putString("password", password);
                        editer.putBoolean("isChecked", true);
                        editer.commit();

                    } else {
                        editer.remove("userName");
                        editer.remove("password");
                        editer.remove("isChecked");
                        editer.commit();
                    }
                    loginMessageTextView.setText("登陆成功");
                } else {
                    loginMessageTextView.setText("登陆失败");
                    new AlertDialog.Builder(LoginDemoActivity.this)
                            .setMessage("登录失败,请重试？")
                            .setPositiveButton("好", null)
                            .show();
                }

            }
        });


    }
}
