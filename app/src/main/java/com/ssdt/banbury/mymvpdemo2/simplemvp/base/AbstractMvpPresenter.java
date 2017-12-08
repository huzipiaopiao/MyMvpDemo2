package com.ssdt.banbury.mymvpdemo2.simplemvp.base;

import com.ssdt.banbury.mymvpdemo2.simplemvp.IMvpBaseView;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_14:25.
 * @description
 */

public abstract class AbstractMvpPresenter<V extends IMvpBaseView> {
    protected V mMvpView;

    /**
     * 绑定V层
     *
     * @param view
     */
    public void attachMvpView(V view) {
        mMvpView = view;
    }

    /**
     * 解绑V层
     */
    public void detachMvpView() {
        mMvpView = null;
    }

    public V getmMvpView() {
        return mMvpView;
    }
}
