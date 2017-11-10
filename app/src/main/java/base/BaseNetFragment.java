package base;

import android.view.View;

import com.google.gson.Gson;

import java.util.Map;

import view.MainStateView;

/**
 *  * 典型的MVP架构设计
 * View：显示数据并且和用户交互的层。在安卓中，它们可以是一个Activity，一个Fragment，一个android.view.View或者是一个Dialog。
 * Model：数据源层
 * Presenter：从model中获取数据，并提供给View的层，Presenter还负责处理后台任务
 *
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0425/2782.html
 *
 */

public class BaseNetFragment extends BaseFragment implements MainStateView {

    Gson gson=new Gson();



    @Override
    protected void initPresenter() {

    }

    @Override
    public int setRequestMethod() {
        return 0;
    }

    @Override
    public Map setparams() {
        return null;
    }

    @Override
    public String setRequestURL() {
        return null;
    }

    @Override
    public View createSucceedView() {
        return null;
    }

    @Override
    public void onNetSucceed(String response) {

    }

    @Override
    public void showSucceedView(boolean show) {

    }

    @Override
    public void showEmptyView(boolean show) {

    }

    @Override
    public void showErrorView(boolean show) {

    }

    @Override
    public void showLoadingView(boolean show) {

    }
}
