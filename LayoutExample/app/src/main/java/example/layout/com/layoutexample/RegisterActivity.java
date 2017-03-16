package example.layout.com.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle();
    }

    /**
     * 重置标题
     */
    public void setTitle() {
        int type = this.getIntent().getIntExtra("type", 0);
        Log.i("info", "type:" + type);
        System.out.println("type:" + type);
        if (type == 1) {
            this.setTitle(R.string.register_view_title);
        } else {
            this.setTitle(R.string.changePassword_view_title);
        }
    }
}
