package com.anioncode.databindingexample.Connection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GetRetrofit {

    @GET("search/photos?client_id=LLmSlJxkKmlSk2MyZ8SlAtbTaYt_CmHVGH5MZLfnoO0&page=1&query=Game")
    Call<ApiConnect> getAdminQuestions();

}
