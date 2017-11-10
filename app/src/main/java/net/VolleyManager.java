package net;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utils.BaseApplication;

/**
 * Created by pengjingang on 2017/4/21.
 */

public class VolleyManager {

    private final RequestQueue mRequestQueue;
    private static VolleyManager volleyManager;
    private static String TAG = "VolleyManager";
    public static final String PROTOCOL_CHARSET = "utf-8";
    private String cookie;


    public VolleyManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyManager getInstance() {
        return create(BaseApplication.getContext());
    }

    private static VolleyManager create(Context context) {
        context = context.getApplicationContext();
        synchronized (VolleyManager.class) {
            if (volleyManager == null) {
                volleyManager = new VolleyManager(context);
            }
        }
        return volleyManager;
    }

    public void cancel(Object tag) {
        mRequestQueue.cancelAll(tag);
    }

    public void getSring(String url, final Map<String, String> urlParams, final Object tag, final NetResult result) {
        createRequest(Request.Method.GET, url, urlParams, tag, result);
    }

    public void postString(String url, Map<String, String> params, Object tag, final NetResult result) {
        createRequest(Request.Method.POST, url, params, tag, result);
    }

    private void createRequest(int method, final String url, final Map<String, String> urlParams, Object tag, final NetResult result) {
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.onSucceed(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                StackTraceElement[] stackTrace = volleyError.getStackTrace();
                for (int i = stackTrace.length - 1; i >= 0; i--) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    Log.e(TAG, "volleyerror:" + volleyError.toString());
                }
                Log.e(TAG, volleyError.getStackTrace() + "");

                if (volleyError.networkResponse != null) {
                    Log.e(TAG, "volleyerror :" + volleyError.toString() + ">>" +
                            volleyError.networkResponse.statusCode + ">>" +
                            volleyError.networkResponse.data + ">>" +
                            volleyError.getCause() + ">>" +
                            volleyError.getMessage());
                } else {
                    Log.e(TAG, "volleyError.networkResponse is null");
                }
                result.onFailure(volleyError);
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                Map<String, String> headers = response.headers;
                Log.e(TAG, "response.headers :" + response.headers);
                String rawCookies = headers.get("Set-Cookie");
                Log.e(TAG, "getCookie:" + rawCookies);
                String parsed;
                try {
                    parsed = new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
                } catch (UnsupportedEncodingException e) {
                    parsed = new String(response.data);
                }
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return urlParams;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> mHeaders = new HashMap<>();
                mHeaders.put("Cookie", cookie);
                Log.e(TAG, "setCookie: " + cookie);
                return mHeaders;
            }
        };
        stringRequest.setTag(tag);
        mRequestQueue.add(stringRequest);
    }

    public String getJsonArray(String url, Map<String, String> map, Object tag, final NetResult result) {
        url += "?";
        StringBuffer stringBuffer = new StringBuffer(url);
        if (null != map && map.size() > 0) {
            for (String key : map.keySet()) {
                if (map.get(key) != null) {
                    stringBuffer.append(key + "=" + map.get(key).toString() + "&");
                } else {
                    Log.e(TAG, "params value is:" + map.get(key));
                }
            }
        }
        return stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
    }

    public void setCookie(String cookie) {
        this.cookie = "JSESSIONID=" + cookie;
    }

    public String getCookie() {
        return this.cookie;
    }

}
