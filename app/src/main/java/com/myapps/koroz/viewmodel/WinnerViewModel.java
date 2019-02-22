package com.myapps.koroz.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.myapps.koroz.service.model.ResultBattle;
import com.myapps.koroz.service.repo.ApiRepository;

public class WinnerViewModel extends ViewModel {
    private MutableLiveData<ResultBattle> viewModel;

    public WinnerViewModel() {
        viewModel = new MutableLiveData<>();
    }

    public MutableLiveData<ResultBattle> getViewModel() {
        return viewModel;
    }

    public void battle() {
        ApiRepository.getInstance().battle(viewModel);
    }
}
