package imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

/**
 * Demo class
 *
 * @author pengjingang
 * @date 2018/1/29
 */

public interface ImageLoaderInterface {
    void display(ImageView imageView,String url);
    void display(ImageView imageView,int resId);

    void display(ImageView imageView,String url,int loadingImg,int errorImg);
    void display(ImageView imageView,int resId,int loadingImg,int errorImg);

    void displayCircleImg(ImageView imageView, int resId);
    void displayCircleImg(Context context, String url, GlideDrawableImageViewTarget glideDrawableImageViewTarget);

    void displayCircleImg(ImageView imageView,String url);

    void displayAsBitmap(Context context, String url, Target<Bitmap> bitmapTarget);

}
