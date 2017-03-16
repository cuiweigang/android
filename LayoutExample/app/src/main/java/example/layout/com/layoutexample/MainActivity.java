package example.layout.com.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static example.layout.com.layoutexample.helper.ViewHelper.goToView;

public class MainActivity extends AppCompatActivity {

    TextView registerTextView;
    TextView changePasswordTextView;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerTextView = (TextView) findViewById(R.id.RegisterButton);
        changePasswordTextView = (TextView) findViewById(R.id.changePasswordButton);
        loginButton = (Button) findViewById(R.id.loginButton);

        setListenerEvent();
    }

    /**
     * 设置监听事件
     */
    private void setListenerEvent() {

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToView(v, RegisterActivity.class, "type", 1);
            }
        });

        changePasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToView(v, RegisterActivity.class, "type", 2);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToView(v, HomeActivity.class);
            }
        });
    }
}
