package com.soulkitchen.serifenuruysal.autoapp.api;


import com.soulkitchen.serifenuruysal.autoapp.models.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by S.Nur Uysal on 5.12.2018.
 */
public interface ApiService {


    @GET("v1/car-types/manufacturer?wa_key=coding-puzzle-client-449cc9d")
    Call<Response> getManufacturer(@Query("page") int page, @Query("pageSize") int pageSize);


    @GET("v1/car-types/main-types?wa_key=coding-puzzle-client-449cc9d")
    Call<Response> getMainTypes(@Query("page") int page, @Query("pageSize") int pageSize, @Query("manufacturer") String manufacturer);

    @GET("v1/car-types/built-dates?wa_key=coding-puzzle-client-449cc9d")
    Call<Response> getBuildDates(@Query("manufacturer") String manufacturer, @Query("main-type") String mainType);
}
