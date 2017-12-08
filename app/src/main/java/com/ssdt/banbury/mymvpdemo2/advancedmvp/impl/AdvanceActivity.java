package com.ssdt.banbury.mymvpdemo2.advancedmvp.impl;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;
import com.ssdt.banbury.mymvpdemo2.R;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.IAdvanceMvpView;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.annotation.CreatePresenter;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator
 */
@CreatePresenter(AdvancePresenter.class)
public class AdvanceActivity extends BaseMvpActivity<AdvancePresenter, IAdvanceMvpView> implements IAdvanceMvpView {

    @Bind(R.id.tv)
    TextView textView;
    private static final String TAG = "AdvanceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv)
    public void onClick() {
        getPresenter().getAddressId("深圳");
    }

    @Override
    public void requestLoading() {
        Log.e(TAG, "requestLoading: 加载中");
        textView.setText("加载中，请稍后");
    }

    @Override
    public void resultSuccess(AddressBean result) {
        Log.e(TAG, "resultSuccess: " + result.toString());
        textView.setText(result.toString());
    }

    @Override
    public void resultFail(String result) {
        Log.e(TAG, "resultFail: " + result);
        textView.setText(result);
    }
}
