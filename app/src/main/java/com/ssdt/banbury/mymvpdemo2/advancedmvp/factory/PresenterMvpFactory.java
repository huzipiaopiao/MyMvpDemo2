package com.ssdt.banbury.mymvpdemo2.advancedmvp.factory;

import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpPresenter;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.IMvpBaseView;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_17:30.
 * @description
 */

public interface PresenterMvpFactory<V extends IMvpBaseView, P extends BaseMvpPresenter<V>> {
    P createPresenter();
}
