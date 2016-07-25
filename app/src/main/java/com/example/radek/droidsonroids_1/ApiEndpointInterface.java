package com.example.radek.droidsonroids_1;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Radek on 2016-07-25.
 */
public interface ApiEndpointInterface {
        @GET("schedule.json")
        Call<ResponseSchedule> getBootcampAgendaData();
}
