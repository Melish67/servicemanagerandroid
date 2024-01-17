package com.example.mybrsmail.api;

import com.example.mybrsmail.data.ServiceDto;
import com.example.mybrsmail.data.ServiceDtoSita;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/Service/getmail")
    Call<List<ServiceDto>> getServiceStatus();

    @GET("/api/Service/getsita")
    Call<List<ServiceDtoSita>> getServiceSitaStatus();


}
