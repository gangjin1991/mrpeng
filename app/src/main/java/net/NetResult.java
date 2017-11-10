package net;

import com.android.volley.VolleyError;

/**
 * Created by pengjingang on 2017/4/21.
 */

public abstract class NetResult <T>{

    public abstract void onFailure(VolleyError error);
    public abstract void onSucceed(T response);


}
