package com.ssdt.banbury.mymvpdemo2.simplemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ssdt.banbury.mymvpdemo2.simplemvp.IMvpBaseView;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_14:29.
 * @description
 */

public abstract class AbstractMvpActivity<P extends AbstractMvpPresenter<V>, V extends IMvpBaseView> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mPresenter == null) {
            throw new NullPointerException("mPresenter can't null!");
        }

        mPresenter.attachMvpView((V) this);

    }

    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachMvpView();
    }

    public P getmPresenter() {
        return mPresenter;
    }
}
