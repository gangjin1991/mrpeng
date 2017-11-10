package utils;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by pengjingang on 2017/4/21.
 */

public class BaseApplication extends MultiDexApplication {

    private static BaseApplication mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static BaseApplication getApplication() {
        return mContext;
    }

    public BaseApplication getApplicationContext() {
        return mContext;
    }

    public static Context getContext() {
        return BaseApplication.getApplication();
    }


}
