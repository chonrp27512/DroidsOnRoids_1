package com.example.radek.droidsonroids_1;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static java.util.Collections.*;

/**
 * Created by Radek on 2016-07-25.
 */

public class BootcampDayApiManager{

    Retrofit retrofit;
    ApiEndpointInterface apiService;

    public BootcampDayApiManager(){
        retrofit = new Retrofit.Builder()
                //.baseUrl("https://bootcampagenda.firebaseio.com/")
                .baseUrl("http://burno.ga/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        apiService =
                retrofit.create(ApiEndpointInterface.class);
    }

    public void processAgendaData(final OnSuccessListener listener){
        final List<DayResource> result;

        Call<ResponseSchedule> call = apiService.getBootcampAgendaData();

        call.enqueue(new Callback<ResponseSchedule>() {
            @Override
            public void onResponse(Call<ResponseSchedule> call, Response<ResponseSchedule> response) {
                listener.onDataRead(response.body().days);
                Log.d("JSON DATA","" + response.body().days.toString());
            }

            @Override
            public void onFailure(Call<ResponseSchedule> call, Throwable t) {
                listener.onDataRead(Collections.<DayResource>emptyList());
                Log.d("EMPTY DATA", "empty");
            }
        });
    }
}
