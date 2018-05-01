package com.iavariav.root.bekonangmalik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String id;
    private String user_id;
    private String category_id;
    private String judul;
    private String url;
    private String deskripsi;
    private String lokasi;
    private String jenis;
    private String harga;
    private String created_at;
    private String updated_at;

    private String id1;
    private String iklan_id;
    private String filename;
    private String created_at1;
    private String updated_at1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();







    }

    private void getData() {
        ApiService apiService  = ClientGas.getInstanceRetrofit();
        apiService.getData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject object = new JSONObject(response.body().string());
                    JSONArray jsonArray  = object.optJSONArray("iklan");
                    Toast.makeText(MainActivity.this, "Masuk ke Array Iklan : " + jsonArray, Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id = jsonObject.optString("id");
                        user_id = jsonObject.optString("user_id");
                        category_id = jsonObject.optString("category_id");
                        judul = jsonObject.optString("judul");
                        url = jsonObject.optString("url");
                        deskripsi = jsonObject.optString("deskripsi");
                        lokasi = jsonObject.optString("lokasi");
                        jenis = jsonObject.optString("jenis");
                        harga = jsonObject.optString("harga");
                        created_at = jsonObject.optString("created_at");
                        updated_at = jsonObject.optString("updated_at");

                        Toast.makeText(MainActivity.this, "Judul : " + judul, Toast.LENGTH_SHORT).show();

                        JSONArray jsonArray1 = jsonObject.getJSONArray("photos");
                        for (int j = 0; j < jsonArray1.length(); j++) {
                            JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                            Toast.makeText(MainActivity.this, "Masuk ke Array Photos : " + jsonArray1, Toast.LENGTH_SHORT).show();

                            id1 = jsonObject1.optString("id");
                            iklan_id = jsonObject1.optString("iklan_id");
                            filename = jsonObject1.optString("filename");
                            created_at1 = jsonObject1.optString("created_at");
                            updated_at1 = jsonObject1.optString("updated_at");
                        }

                        JSONObject jsonObject1 = jsonObject.optJSONObject("users");
                        Toast.makeText(MainActivity.this, "Masuk ke Object Users : " + jsonObject1, Toast.LENGTH_SHORT).show();
                        String id = jsonObject1.getString("id");
                        String image = jsonObject1.getString("image");
                        String name = jsonObject1.getString("name");
                        String email = jsonObject1.getString("email");
                        String notelp = jsonObject1.getString("notelp");
                        String created_at = jsonObject1.getString("created_at");
                        Toast.makeText(MainActivity.this, "Nama User nya : " + name, Toast.LENGTH_SHORT).show();
                        

                        JSONObject jsonObject2 = jsonObject.optJSONObject("category");
                        Toast.makeText(MainActivity.this, "Masuk ke object Category : " + jsonObject2, Toast.LENGTH_SHORT).show();
                        String id1 = jsonObject2.optString("id");
                        String image1 = jsonObject2.optString("image");
                        String name1 = jsonObject2.optString("name");
                        String created_at1 = jsonObject2.optString("created_at");
                        String updated_at1 = jsonObject2.optString("updated_at");
                        Toast.makeText(MainActivity.this, "Categorynya : "+ name1, Toast.LENGTH_SHORT).show();




                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
