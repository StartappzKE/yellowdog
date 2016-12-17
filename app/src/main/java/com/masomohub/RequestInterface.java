package com.masomohub;

import com.masomohub.json.JSONResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

import static com.masomohub.Config.Constants.path_;


public interface RequestInterface {



    @GET("masomohub/getnotes.php")
    Call <JSONResponse> getJSON();

    @GET("masomohub/")
    @Streaming
    Call<ResponseBody> downloadFile();
}
