package com.myapps.koroz.service.repo;

import com.myapps.koroz.service.model.ResultBattle;
import com.myapps.koroz.service.model.SendUser;
import com.myapps.koroz.service.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    String BASE_URL = "http:185.216.126.7/";

    @POST("/Koroz/User")
    Call<ApiResponse<User>> getUser(@Body SendUser user);

    @POST("/Koroz/Battle")
    Call<ApiResponse<ResultBattle>> battle(@Body SendUser user);


}
