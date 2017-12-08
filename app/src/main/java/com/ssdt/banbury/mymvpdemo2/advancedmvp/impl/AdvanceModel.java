package com.ssdt.banbury.mymvpdemo2.advancedmvp.impl;

import android.util.Log;

import com.ssdt.banbury.mymvpdemo2.net.AddressBean;
import com.ssdt.banbury.mymvpdemo2.net.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_15:11.
 * @description
 */

public class AdvanceModel {
    private static final String TAG = "AdvanceModel";
    public static final String BASE_URL = "http://route.showapi.com/";
    private Call<AddressBean> call;

    public void getAddressId(String address, Callback<AddressBean> callback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        call = apiService.requestAddressByName("50676", "3b68385c2a7a411a83c4cf79552e7966", address);

        call.enqueue(callback);

    }

    public void interruptHttp() {
        if (call != null && !call.isCanceled()) {
            call.cancel();
            Log.e(TAG, "interruptHttp: 取消网络请求");
        }
    }

}
