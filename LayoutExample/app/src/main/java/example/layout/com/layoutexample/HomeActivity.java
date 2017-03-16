package example.layout.com.layoutexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import static example.layout.com.layoutexample.R.*;

public class HomeActivity extends AppCompatActivity {

    GridView jgg_GridView;
    ImageView icon_ImageView;

    private Integer[] images = {drawable.main_icon_1, drawable.main_icon_2, drawable.main_icon_3, drawable.main_icon_4, drawable.main_icon_5, drawable.main_icon_6, drawable.main_icon_7, drawable.white_fill, drawable.white_fill};

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
                viewTag = new ItemViewTag((ImageView) convertView.findViewById(id.icon_ImageView));
                convertView.setTag(viewTag);
            } else {
                viewTag = (ItemViewTag) convertView.getTag();
            }
            viewTag.image.setImageResource(images[position]);
            return convertView;
        }

        class ItemViewTag {
            protected ImageView image;

            public ItemViewTag(ImageView image) {
                this.image = image;
            }
        }
    }

}


