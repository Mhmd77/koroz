package com.myapps.koroz.service.repo;


import android.arch.lifecycle.MutableLiveData;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRepository {
    private static ApiRepository apiRepository;
    protected static ApiService apiService;

    public static String getBaseUrl() {
        return ApiService.BASE_URL;
    }

    private ApiRepository() {
        /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        CookieHandler cookieHandler = new CookieManager();
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor)
                .cookieJar(new JavaNetCookieJar(cookieHandler))
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();*/
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("X-Auth", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImFwYyI6IjZNdDNkUSIsImV4cCI6IjIwMTctMDctMTdUMDg6Mzg6NDguNTMwOTAzNFoifQ.eyJJZCI6MiwiTmFtZSI6Itit2YXbjNiv2LHYttinINmF2LHYp9iv2KfZgSIsIlJvbGVzIjpbM119.z/nv5TbhcwCptz9xZmiFRjnygu3l0iU3JEIdxA9Tp8f2zyHlFY5GG8iy1XyE3doIoZvvXfuf7H5bGX+gPk+HbPbylYRY9fprB4JYBivSuPvP8ryvQXueLDxkvNiVr9f8863NfY+vR20JQ40GaMW2BmszXo2xkjBnVCX5TdCbFWv5aix8HpJXsZw3Jk39+BpTnHWounhH6x6H+4xP0C0vnLTYvJFZyD7v2QQgP8CFHI9Ow01Oy1EJK1L2L8a1tnoq")
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiService = retrofit.create(ApiService.class);

    }

    public synchronized static ApiRepository getInstance() {
        if (apiRepository == null) {
            if (apiRepository == null) {
                apiRepository = new ApiRepository();
            }
        }
        return apiRepository;
    }

    public void getU(MutableLiveData data) {
        GetUserInt getUserInt = new GetUserInt();
        getUserInt.doRequest(data);
    }

    public void battle(MutableLiveData data) {
        BattleInt battleInt = new BattleInt();
        battleInt.doRequest(data);
    }
}
