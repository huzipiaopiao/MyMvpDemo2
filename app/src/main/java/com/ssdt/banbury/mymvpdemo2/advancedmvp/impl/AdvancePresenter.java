package com.ssdt.banbury.mymvpdemo2.advancedmvp.impl;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.IAdvanceMvpView;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_18:35.
 * @description
 */

class AdvancePresenter extends BaseMvpPresenter<IAdvanceMvpView> {

    private AdvanceModel advanceModel;

    public AdvancePresenter() {
        this.advanceModel = new AdvanceModel();
    }

    void getAddressId(final String addressName) {
        if (mMvpView != null) {
            mMvpView.requestLoading();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                advanceModel.getAddressId(addressName, new Callback<AddressBean>() {
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
        }, 1000);

    }

    @Override
    public void onCreatePersenter(@Nullable Bundle savedState) {
        super.onCreatePersenter(savedState);
        if(savedState != null){
            Log.e("perfect-mvp","RequestPresenter5  onCreatePersenter 测试  = " + savedState.getString("test2") );
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp","RequestPresenter5  onSaveInstanceState 测试 " );
        outState.putString("test2","test_save2");
    }


}
