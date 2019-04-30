package com.onexsoftech.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SYSTEM5 on 11/28/2018.
 */

public interface Api {
    @GET("/3/movie/top_rated")
    Call<Movie> getMovieList(@Query("api_key") String key);
    @GET("/tutorial/jsonparsetutorial.txt")
    Call<Model2> getText();
}
