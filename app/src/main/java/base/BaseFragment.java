package base;

import android.support.v4.app.Fragment;

/**

 * <功能详细描述>
 *
 * @author pengjingnag
 * @see [相关类/方法]
 * @since [产品/模板版本]
 * @deprecated
 */
public abstract class BaseFragment extends Fragment
{
    protected abstract void initPresenter();

    /**
     * 实现在fragment可见时才进行数据加载操作，即Fragment的懒加载。
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        initPresenter();
        super.setUserVisibleHint(isVisibleToUser);
    }
}
