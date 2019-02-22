package com.myapps.koroz.service.repo;

import com.myapps.koroz.service.model.ResultBattle;
import com.myapps.koroz.service.model.SendUser;

import retrofit2.Call;

public class BattleInt extends GenericRequestHandler<ResultBattle> {
    @Override
    protected Call<ApiResponse<ResultBattle>> makeRequest() {
        return ApiRepository.apiService.battle(new SendUser(1));
    }
}
