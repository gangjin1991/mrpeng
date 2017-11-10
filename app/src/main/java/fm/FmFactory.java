package fm;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

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
public class FmFactory {
    private static final int ONE = 0;
    private static final int TWO = 1;
    private static final int THREE = 2;
    private static final int FOUR = 3;


    private Map<Integer, BaseFragment> fmcache = new HashMap<Integer, BaseFragment>();


    public Fragment createFragment(int type) {
        BaseFragment fragment = fmcache.get(type);
        if (fragment == null) {
            switch (type) {
                case ONE:
                    fragment = new BaiduMeinv();
                    break;
                case TWO:
                    fragment = new BbbFm();
                    break;
                case THREE:
                    fragment = new CccFm();
                    break;
                case FOUR:
                    fragment = new DddFm();
                    break;
                default:
                    break;
            }
            fmcache.put(type, fragment);
        }
        return fragment;
    }
}
