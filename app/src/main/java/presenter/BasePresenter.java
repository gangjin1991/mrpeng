package presenter;

import android.content.Context;

import com.android.volley.toolbox.Volley;

import view.BaseView;

/**
 * Created by pengjingang on 2017/4/20.
 */
public class BasePresenter<JV extends BaseView> {

    protected JV mView;
    protected Context mConext;


    public BasePresenter(Context context, JV view) {
        this.mView = view;
        mConext = context;
    }
}
