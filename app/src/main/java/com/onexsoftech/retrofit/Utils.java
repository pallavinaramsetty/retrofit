package com.onexsoftech.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SYSTEM5 on 11/28/2018.
 */

public class Utils {
    public static String url = "http://api.themoviedb.org";
    public static String url2 = "https://www.androidbegin.com";

    public static Retrofit callUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public static Retrofit callUrl1() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
