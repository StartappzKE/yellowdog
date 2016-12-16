package com.masomohub;

import com.masomohub.json.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("masomohub/getnotes.php")
    Call <JSONResponse> getJSON();

}
