package cn.maitian.util;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cn.maitian.R;

/**
 * Created by geng on 2016/7/19.
 */
public class GlideUtil {

    public static void loadImage(Activity activity, String url, ImageView imageView) {
        Glide.with(activity)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    public static void loadImage(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }
}
