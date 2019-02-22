package com.myapps.koroz.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.myapps.koroz.service.model.User;
import com.myapps.koroz.service.repo.ApiRepository;

public class GetUserViewModel extends ViewModel {
    MutableLiveData<User> viewModel;

    public GetUserViewModel() {
        this.viewModel = new MutableLiveData<>();
    }

    public MutableLiveData<User> getViewModel() {
        return viewModel;
    }

    public void getUser() {
        ApiRepository.getInstance().getU(viewModel);
    }
}
