package base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Demo class
 *
 * @author pengjingang
 * @date 2018/1/30
 */

public abstract class BaseFragment extends Fragment
{
    protected View mRootView;
    protected Context mContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRootView(inflater, container);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    protected void init() {
        mContext = getActivity();
        initView();
        initData();
    }

    protected abstract void initRootView(LayoutInflater inflater, ViewGroup container) ;

    protected abstract void initView();

    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
//        RefWatcher refWatcher = App.
//        refWatcher.watch(this);
    }
}
