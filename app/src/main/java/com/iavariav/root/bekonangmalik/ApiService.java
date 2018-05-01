package com.iavariav.root.bekonangmalik;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    //    @GET("AKfycbzSX0VVb_KNsORvGBc3q6dPrelDQAFGpc4JyvR-79tuKuKppYEK/exec?action=read&sheetName=register")
    @GET("iklan")
    Call<ResponseBody> getData();
}
