package com.anioncode.databindingexample.binding;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anioncode.databindingexample.model.ImageModel;

import java.util.List;

public class MainViewModelView extends AndroidViewModel {
    private MutableData mutableData;

    public MainViewModelView(@NonNull Application application) {
        super(application);
        mutableData = new MutableData();
    }

    public LiveData<List<ImageModel>> getAllEmployee() {
        return mutableData.getMutableLiveData();
    }
}

