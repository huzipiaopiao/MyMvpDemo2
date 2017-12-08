package com.ssdt.banbury.mymvpdemo2.simplemvp;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_14:51.
 * @description
 */

public interface ISimpleMvpView extends IMvpBaseView {

    void requestLoading();

    void resultSuccess(AddressBean result);

    void resultFail(String result);

}
