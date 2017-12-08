package com.ssdt.banbury.mymvpdemo2.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_15:04.
 * @description
 */

public interface ApiService {

    @GET("9-3/")
    Call<AddressBean> requestAddressByName(@Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("area") String area);
}
