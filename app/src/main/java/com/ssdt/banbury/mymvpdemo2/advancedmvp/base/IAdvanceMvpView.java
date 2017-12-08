package com.ssdt.banbury.mymvpdemo2.advancedmvp.base;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_18:33.
 * @description
 */

public interface IAdvanceMvpView extends IMvpBaseView {
    /**
     * 请求加载
     */
    void requestLoading();

    void resultSuccess(AddressBean result);

    void resultFail(String result);
}
