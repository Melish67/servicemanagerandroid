package com.example.mybrsmail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybrsmail.api.ApiService;
import com.example.mybrsmail.api.RetrofitClient;
import com.example.mybrsmail.data.ServiceDto;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit = RetrofitClient.getClient();
    ApiService iUsersApi = retrofit.create(ApiService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // TextView textView = findViewById(R.id.ziya);
        Button buttonMail = findViewById(R.id.buttonMail);
        Button buttonSita = findViewById(R.id.buttonSita);

        buttonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
              //  funcGetServiceData();
            }
        });

        buttonSita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivitySita.class);
                startActivity(intent);
                //  funcGetServiceData();
            }
        });
    }

/*    private void funcGetServiceData() {
        Call<List<ServiceDto>> call = iUsersApi.getServiceStatus();
        // on below line we are executing our method.
        call.enqueue(new Callback<List<ServiceDto>>() {
            @Override
            public void onResponse(Call<List<ServiceDto>> call, Response<List<ServiceDto>> response) {
                // this method is called when we get response from our api.
               // Toast.makeText(MainActivity.this, "Success: " + response.body() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ServiceDto>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getLocalizedMessage()+"-"+t.getCause(), Toast.LENGTH_SHORT).show();
                System.out.println("Error"+t.getLocalizedMessage()+"-"+t.getCause() + "-"+ Arrays.toString(t.getStackTrace()));
            }
        });
    }*/
}