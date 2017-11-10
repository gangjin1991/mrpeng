package view;

/**
 * Created by pengjingang on 2017/4/20.
 */
public interface StateView extends BaseView{

    /**
     * 数据加载成功
     * @param show
     */
    void showSucceedView(boolean show);

    /**
     * 数据为空
     * @param show
     */

    void showEmptyView(boolean show);

    /**
     * 网络错误
     * @param show
     */
    void showErrorView(boolean show);

    /**
     * 正在加载
     * @param show
     */
    void showLoadingView(boolean show);
}
