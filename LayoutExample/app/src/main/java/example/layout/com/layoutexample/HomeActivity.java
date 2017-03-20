package example.layout.com.layoutexample;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import static example.layout.com.layoutexample.R.*;

public class HomeActivity extends AppCompatActivity {

    GridView jgg_GridView;
    ImageView icon_ImageView;

    private Integer[] images = {drawable.icon_1, drawable.icon_2, drawable.icon_3, drawable.icon_4, drawable.icon_5, drawable.icon_6, drawable.icon_7, drawable.white_fill, drawable.white_fill};
    private String[] titles = {"商品管理", "订单管理", "我的收入", "喵客二维码", "佣金计划", "我的喵币", "敬请期待...", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);
        jgg_GridView = (GridView) findViewById(id.jgg_GridView);

        icon_ImageView = (ImageView) findViewById(id.icon_ImageView);
        jgg_GridView.setAdapter(new ImageAdapter(this));
    }


    public class ImageAdapter extends BaseAdapter {

        Context context;
        LayoutInflater layoutInflater;

        public ImageAdapter(Context context) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
        }

        private Context mContext;
        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemViewTag viewTag;
            if (convertView == null) {
                convertView = layoutInflater.inflate(layout.gridview_item, null);
                viewTag = new ItemViewTag((ImageView) convertView.findViewById(id.icon_ImageView), (TextView) convertView.findViewById(id.icon_title));
                convertView.setTag(viewTag);
            } else {
                viewTag = (ItemViewTag) convertView.getTag();
            }
            viewTag.image.setImageResource(images[position]);
            viewTag.text.setText(titles[position]);
            if (position == 6) {
                viewTag.text.setTextColor(context.getResources().getColor(color.split_line));
            }
            return convertView;
        }

        class ItemViewTag {
            protected ImageView image;
            protected TextView text;

            public ItemViewTag(ImageView image, TextView text) {
                this.image = image;
                this.text = text;
            }
        }
    }

}


