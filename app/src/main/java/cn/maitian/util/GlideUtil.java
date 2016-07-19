package cn.maitian.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cn.maitian.R;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by geng on 2016/7/19.
 */
public class GlideUtil {

    public final static int sCropCircleTransformation = 1;
    public final static int sRoundedCornersTransformation = 2;
    public final static int sBlurTransformation = 3;

    // -----------------activity-----------------
    public static void loadTransformationImage(Activity activity, String url, int transformation, ImageView imageView) {
        final RequestManager manager = Glide.with(activity);
        config(manager, url)
                .bitmapTransform(generateBitmapTransformation(activity, transformation))
                .into(imageView);
    }

    public static void loadImage(Activity activity, String url, ImageView imageView) {
        final RequestManager manager = Glide.with(activity);
        config(manager, url).into(imageView);
    }

    // -----------------fragment-----------------
    public static void loadTransformationImage(Fragment fragment, String url, int transformation, ImageView imageView) {
        final RequestManager manager = Glide.with(fragment);
        config(manager, url)
                .bitmapTransform(generateBitmapTransformation(fragment.getContext(), transformation))
                .into(imageView);
    }

    public static void loadImage(Fragment fragment, String url, ImageView imageView) {
        final RequestManager manager = Glide.with(fragment);
        config(manager, url).into(imageView);
    }

    // -----------------common-----------------
    private static DrawableRequestBuilder<String> config(RequestManager manager, String url) {
        return manager.load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESULT);
    }

    private static Transformation<Bitmap> generateBitmapTransformation(Context context, int transformation) {
        Transformation<Bitmap> bitmapTransformation = null;

        switch (transformation) {
            case sCropCircleTransformation:
                bitmapTransformation = new CropCircleTransformation(context);
                break;
            case sRoundedCornersTransformation:
                bitmapTransformation = new RoundedCornersTransformation(context, 5, 5);
                break;
            case sBlurTransformation:
                bitmapTransformation = new BlurTransformation(context, 25);
                break;
            default:
                break;
        }

        return bitmapTransformation;
    }
}
