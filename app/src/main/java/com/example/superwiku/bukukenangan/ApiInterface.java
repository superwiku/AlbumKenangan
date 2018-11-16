package com.example.superwiku.bukukenangan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("bins/134jza")
    Call<List<Member>> getAllMember();
}
