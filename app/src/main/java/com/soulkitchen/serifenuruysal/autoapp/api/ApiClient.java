package com.soulkitchen.serifenuruysal.autoapp.api;


import com.soulkitchen.serifenuruysal.autoapp.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by S.Nur Uysal on 3.02.2019.
 */
public class ApiClient {


    private static final String TAG = "ApiClient";
    private static final String BASE_URL = "http://api-aws-eu-qa-1.auto1-test.com/";
    private static final OkHttpClient client;
    private static ApiService mService;
    static {

        client = new OkHttpClient.Builder()
//                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new AuthInterceptor())
                .build();

    }
    public static ApiService getInstance() {
        synchronized (new Object()) {
            if (mService == null) {
                mService = getRetrofitInstance().create(ApiService.class);
        }
            return mService;
        }
    }

private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();
        }

    public ApiService getService() {
        return mService;
    }

    public static class AuthInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            HttpUrl url = request.url().newBuilder()
//                    .addQueryParameter("wa_key", "coding-puzzle-client-449cc9d")
//                    .addQueryParameter("language", "en-US")
//                    .addQueryParameter("region", "en-US")
                    .build();

            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        }


    }

}
