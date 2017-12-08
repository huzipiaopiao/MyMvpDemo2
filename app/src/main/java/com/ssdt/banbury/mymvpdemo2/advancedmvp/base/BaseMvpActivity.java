package com.ssdt.banbury.mymvpdemo2.advancedmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ssdt.banbury.mymvpdemo2.advancedmvp.proxy.BaseMvpProxy;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.proxy.PresenterProxyInterface;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.factory.PresenterMvpFactory;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.factory.PresenterMvpFactoryImpl;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_14:29.
 * @description
 */

public abstract class BaseMvpActivity<P extends BaseMvpPresenter<V>, V extends IMvpBaseView> extends AppCompatActivity implements PresenterProxyInterface<V, P> {

    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";


    private BaseMvpProxy<V, P> mProxy = new BaseMvpProxy<>(PresenterMvpFactoryImpl.<V, P>createFactory(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("perfect-mvp", "V onResume");
        mProxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("perfect-mvp", "V onDestroy = ");
        mProxy.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp", "V onSaveInstanceState");
        outState.putBundle(PRESENTER_SAVE_KEY, mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> factory) {
        Log.e("perfect-mvp", "V setPresenterFactory");
        mProxy.setPresenterFactory(factory);
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        Log.e("perfect-mvp", "V getPresenterFactory");
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getPresenter() {
        Log.e("perfect-mvp", "V getMvpPresenter");
        return mProxy.getPresenter();
    }
}
