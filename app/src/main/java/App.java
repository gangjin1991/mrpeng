import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import imageloader.GlideImageLoader;
import imageloader.ImageUtils;

/**
 * Demo class
 *
 * @author pengjingang
 * @date 2018/1/29
 */

public class App extends Application{

    private static App application;
    public static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        ImageUtils.getInstance().init(new GlideImageLoader());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        sRefWatcher = LeakCanary.install(this);


    }

    public static Context getApplication(){
        return application;
    }
}
