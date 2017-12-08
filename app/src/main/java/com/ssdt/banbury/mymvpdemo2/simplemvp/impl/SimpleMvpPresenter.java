package com.ssdt.banbury.mymvpdemo2.simplemvp.impl;


import android.os.Handler;
import android.util.Log;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;
import com.ssdt.banbury.mymvpdemo2.simplemvp.base.AbstractMvpPresenter;
import com.ssdt.banbury.mymvpdemo2.simplemvp.ISimpleMvpView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_14:47.
 * @description
 */

public class SimpleMvpPresenter extends AbstractMvpPresenter<ISimpleMvpView> {


    private final SimpleModel simpleModel;

    public SimpleMvpPresenter() {
        simpleModel = new SimpleModel();
    }

    public void getAddressId(final String addressName) {
        if (mMvpView != null) {
            mMvpView.requestLoading();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                simpleModel.getAddressId(addressName, new Callback<AddressBean>() {
                    @Override
                    public void onResponse(Call<AddressBean> call, Response<AddressBean> response) {
                        if (mMvpView != null) {
                            mMvpView.resultSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<AddressBean> call, Throwable t) {
                        if (mMvpView != null) {
                            mMvpView.resultFail(Log.getStackTraceString(t));
                        }
                    }
                });
            }
        },5000);

    }

    public void interruptHttp() {
        simpleModel.interruptHttp();
    }
}
