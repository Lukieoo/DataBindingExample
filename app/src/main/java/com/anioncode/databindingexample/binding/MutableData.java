package com.anioncode.databindingexample.binding;

import androidx.lifecycle.MutableLiveData;

import com.anioncode.databindingexample.Connection.ApiConnect;
import com.anioncode.databindingexample.Connection.GetRetrofit;
import com.anioncode.databindingexample.Connection.RetrofitClientInstance;
import com.anioncode.databindingexample.model.ImageModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MutableData {
    private static final String TAG = "MutableData";
    private ArrayList<ImageModel> datas = new ArrayList<>();
    private MutableLiveData<List<ImageModel>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<ImageModel>> getMutableLiveData() {

        GetRetrofit service = RetrofitClientInstance.getRetrofitInstance().create(GetRetrofit.class);
        Call<ApiConnect> call = service.getAdminQuestions();
        call.enqueue(new Callback<ApiConnect>() {
            @Override
            public void onResponse(Call<ApiConnect> call, Response<ApiConnect> response) {
//                mSwipeRefreshLayout.setRefreshing(false);
                //finally we are setting the list to our MutableLiveData

                ApiConnect jsonResponse = response.body();
                if (jsonResponse != null && jsonResponse.getApi() != null) {

                    datas = new ArrayList<>(Arrays.asList(jsonResponse.getApi()));


                    mutableLiveData.setValue(datas);
                }

            }

            @Override
            public void onFailure(Call<ApiConnect> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
