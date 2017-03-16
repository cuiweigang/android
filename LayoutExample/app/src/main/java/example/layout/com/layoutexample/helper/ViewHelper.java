package example.layout.com.layoutexample.helper;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;

/**
 * Created by cuiweigang on 2017/3/16 0016.
 */

/**
 * 视图帮助类
 */
public class ViewHelper {

    /**
     * 跳转视图
     *
     * @param v        当前View
     * @param activity 目标Activity类
     * @param bundle   参数值
     */
    public static void goToView(View v, Class<?> activity, Bundle bundle) {
        Intent i = new Intent(v.getContext(), activity);
        i.putExtras(bundle);
        v.getContext().startActivity(i);
    }

    /**
     * 跳转视图
     *
     * @param v           当前View
     * @param activity    目标Activity类
     * @param paramsName  参数名称
     * @param paramsValue 参数值
     */
    public static void goToView(View v, Class<?> activity, String paramsName, Object paramsValue) {
        Bundle bundle = new Bundle();
        if (paramsValue instanceof String) {
            bundle.putString(paramsName, (String) paramsValue);

        } else if (paramsValue instanceof Integer) {
            bundle.putInt(paramsName, (Integer) paramsValue);
        } else if (paramsValue instanceof Boolean) {
            bundle.putBoolean(paramsName, (Boolean) paramsValue);
        }

        goToView(v, activity, bundle);
    }

    /**
     * 跳转视图
     *
     * @param v 当前View
     * @param activity 目标Activity类
     */
    public static void goToView(View v, Class<?> activity) {
        Bundle bundle = new Bundle();
        goToView(v, activity, bundle);
    }
}
