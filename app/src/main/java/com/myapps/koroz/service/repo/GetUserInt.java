package com.myapps.koroz.service.repo;

import com.myapps.koroz.service.model.SendUser;
import com.myapps.koroz.service.model.User;

import retrofit2.Call;

public class GetUserInt extends GenericRequestHandler<User> {
    @Override
    protected Call<ApiResponse<User>> makeRequest() {
        return ApiRepository.apiService.getUser(new SendUser(1));
    }
}
