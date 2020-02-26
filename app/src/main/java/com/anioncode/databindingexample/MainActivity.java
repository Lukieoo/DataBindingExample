package com.anioncode.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.anioncode.databindingexample.Connection.ApiConnect;
import com.anioncode.databindingexample.Connection.GetRetrofit;
import com.anioncode.databindingexample.Connection.RetrofitClientInstance;
import com.anioncode.databindingexample.Model.ImageModel;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageModel> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


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
                    System.out.println(jsonResponse.toString());
                //    heroList.setValue(datas);

                }

            }

            @Override
            public void onFailure(Call<ApiConnect> call, Throwable t) {
            }
        });

    }

}
