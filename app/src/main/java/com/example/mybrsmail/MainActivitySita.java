package com.example.mybrsmail;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mybrsmail.adapter.AdapterSubList;
import com.example.mybrsmail.api.ApiService;
import com.example.mybrsmail.api.RetrofitClient;
import com.example.mybrsmail.data.Item;
import com.example.mybrsmail.data.ServiceDto;
import com.example.mybrsmail.data.ServiceDtoSita;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivitySita extends AppCompatActivity {

    ProgressDialog progress;
    Retrofit retrofit = RetrofitClient.getClient();
    ApiService iUsersApi = retrofit.create(ApiService.class);

    private SwipeRefreshLayout refreshOnclick;
    private RecyclerView rvItem;
    private AdapterSubList itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sita);
        init();
        functionReloadSitaList();
    }

    private void functionReloadSitaList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivitySita.this);
        AdapterSubList itemAdapter = new AdapterSubList(MainActivitySita.this, buildItemList());
        rvItem.setAdapter(itemAdapter);
        rvItem.setLayoutManager(layoutManager);
    }

    private List<Item> buildItemList() {
        final List<Item> itemList = new ArrayList<>();
        Call<List<ServiceDtoSita>> call = iUsersApi.getServiceSitaStatus();
        progress = new ProgressDialog(MainActivitySita.this);
        progress.setMessage("Please wait...");
        progress.show();

        call.enqueue(new Callback<List<ServiceDtoSita>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ServiceDtoSita>> call, Response<List<ServiceDtoSita>> response) {
                if (response.isSuccessful()) {
                    itemList.clear();
                    assert response.body() != null;
                    for (int i = 0; i < response.body().size(); i++) {
                        Item orderItem = new Item();
                        orderItem.setItemTitle(response.body().get(i).getServiceName().toString());
                        orderItem.setItemTitle2(response.body().get(i).getDescription().toString());
                        orderItem.setItemTitle3(response.body().get(i).getLastDate());
                        orderItem.setItemTitle4(response.body().get(i).getIsActive().toString());
                        itemList.add(orderItem);
                    }
                    itemAdapter = new AdapterSubList(MainActivitySita.this, itemList);
                    rvItem.setAdapter(itemAdapter);
                    rvItem.invalidate();
                } else {
                    System.out.println("Sorry,not found!");
                }
                progress.dismiss();
                refreshOnclick.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<ServiceDtoSita>> call, Throwable t) {
                Log.e("error", t.getMessage());
                System.out.println("Network Error!");
                progress.dismiss();
                refreshOnclick.setRefreshing(false);
            }
        });
        return itemList;
    }


    private void init() {
        rvItem = findViewById(R.id.recyclerView);
        refreshOnclick = findViewById(R.id.refreshId);
    }
}