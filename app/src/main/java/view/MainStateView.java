package view;

import android.view.View;

import java.util.Map;

/**
 * Created by pengjingang on 2017/4/20.
 */
public interface MainStateView extends StateView{

    /**
     * 请求方式
     * @return
     */
    int setRequestMethod();

    /**
     * 网络请求参数
     * @return
     */
    Map setparams();

    /**
     * 1设置请求url地址 对象
     * @return
     */
    String setRequestURL();

    /**
     *2、设置请求url地址 对象
     * @return
     */
    View createSucceedView();

    /**
     * 3、拿到数据之后，解析数据，填充界面
     * @param response
     */
    void onNetSucceed(String response);




}
