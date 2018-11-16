package com.example.superwiku.bukukenangan;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    private ApiInterface apiInterface;
    private Member member;
    private List<Member> memberList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilData().execute();
    }


    private class AmbilData extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<Member>> call=apiInterface.getAllMember();
            call.enqueue(new Callback<List<Member>>() {
                @Override
                public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                    memberList=response.body();
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    intent.putExtra("datanya",(Serializable)memberList);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<List<Member>> call, Throwable t) {

                }
            });
            return null;
        }
    }
}
