package com.ssdt.banbury.mymvpdemo2.simplemvp.impl;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;
import com.ssdt.banbury.mymvpdemo2.R;
import com.ssdt.banbury.mymvpdemo2.simplemvp.base.AbstractMvpActivity;
import com.ssdt.banbury.mymvpdemo2.simplemvp.ISimpleMvpView;

/**
 * @author Administrator
 */
public class SimpleMvpActivity extends AbstractMvpActivity<SimpleMvpPresenter, ISimpleMvpView> implements ISimpleMvpView {
    private static final String TAG = "SimpleMvpActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mvp);
        textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAddressId("长沙");
            }
        });
    }

    @Override
    protected SimpleMvpPresenter createPresenter() {
        return new SimpleMvpPresenter();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.interruptHttp();
    }
}
