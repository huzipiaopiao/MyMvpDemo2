package com.ssdt.banbury.mymvpdemo2.advancedmvp.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_14:25.
 * @description
 */

public abstract class BaseMvpPresenter<V extends IMvpBaseView> {
    protected V mMvpView;

    public void onCreatePersenter(@Nullable Bundle savedState) {
        Log.e("perfect-mvp", "P onCreatePersenter = ");
    }

    /**
     * 绑定View
     */
    public void onAttachMvpView(V mvpView) {
        mMvpView = mvpView;
        Log.e("perfect-mvp", "P onResume");
    }

    /**
     * 解除绑定View
     */
    public void onDetachMvpView() {
        mMvpView = null;
        Log.e("perfect-mvp", "P onDetachMvpView = ");
    }

    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPersenter() {
        Log.e("perfect-mvp", "P onDestroy = ");
    }

    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {
        Log.e("perfect-mvp", "P onSaveInstanceState = ");
    }

    /**
     * 获取V层接口View
     *
     * @return 返回当前MvpView
     */
    public V getMvpView() {
        return mMvpView;
    }
}
