package com.ssdt.banbury.mymvpdemo2.advancedmvp.factory;

import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpPresenter;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.IMvpBaseView;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/8_15:39.
 * @description
 */

public class PresenterMvpFactoryImplByDagger2<V extends IMvpBaseView, P extends BaseMvpPresenter<V>> implements PresenterMvpFactory<V,P> {
    @Override
    public P createPresenter() {
        return null;
    }
}
