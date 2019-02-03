package com.soulkitchen.serifenuruysal.autoapp.api;


import com.soulkitchen.serifenuruysal.autoapp.models.AutoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by S.Nur Uysal on 3.02.2019.
 */
public interface ApiService {


    @GET("v1/car-types/manufacturer?wa_key=coding-puzzle-client-449cc9d")
    Call<AutoResponse> getManufacturer(@Query("page") long page, @Query("pageSize") int pageSize);

    @GET("v1/car-types/main-types?wa_key=coding-puzzle-client-449cc9d")
    Call<AutoResponse> getMainTypes(@Query("page") long page, @Query("pageSize") int pageSize, @Query("manufacturer") String manufacturer);

    @GET("v1/car-types/built-dates?wa_key=coding-puzzle-client-449cc9d")
    Call<AutoResponse> getBuildDates(@Query("manufacturer") String manufacturer, @Query("main-type") String mainType);
}
