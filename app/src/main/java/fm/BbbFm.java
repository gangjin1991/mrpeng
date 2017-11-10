package fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrpeng.myandroid.R;

import base.BaseFragment;


/**
 * <一句话功能描述>
 * <功能详细描述>
 *
 * @author pengjingnag
 * @see [相关类/方法]
 * @since [产品/模板版本]
 * @deprecated
 */
public class BbbFm extends BaseFragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View inflate = View.inflate(getContext(), R.layout.fm_bbb, null);
        return inflate;
    }








    @Override
    protected void initPresenter()
    {

    }
}
