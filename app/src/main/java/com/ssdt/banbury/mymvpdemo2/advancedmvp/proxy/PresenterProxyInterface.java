package com.ssdt.banbury.mymvpdemo2.advancedmvp.proxy;

import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpPresenter;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.IMvpBaseView;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.factory.PresenterMvpFactory;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_17:54.
 * @description 代理接口
 */

public interface PresenterProxyInterface<V extends IMvpBaseView, P extends BaseMvpPresenter<V>> {

    void setPresenterFactory(PresenterMvpFactory<V, P> factory);

    PresenterMvpFactory<V, P> getPresenterFactory();

    P getPresenter();
}
