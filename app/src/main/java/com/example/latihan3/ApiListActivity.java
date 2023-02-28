package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.latihan3.databinding.ActivityApiListBinding;
import com.example.latihan3.databinding.ActivityApiListBindingImpl;
import com.example.latihan3.databinding.ActivityUserListBinding;
import com.example.latihan3.databinding.ItemdigimonlistBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiListActivity extends AppCompatActivity {

    private ActivityApiListBinding binding;
    private final List<DigimonModel> digimonModelList = new ArrayList<>();
    private BaseRecyclerAdapter<DigimonModel> digimonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_api_list);
        digimonAdapter = new BaseRecyclerAdapter<>(
                digimonModelList,
                R.layout.itemdigimonlist,
                ((viewHolder, digimonModel) -> {
                    ItemdigimonlistBinding binding = (ItemdigimonlistBinding) viewHolder.getBinding();
                    binding.setDigimonModel(digimonModel);
                })
        );
        binding.setDigimonModel(digimonAdapter);
        InitApiDigimon();
    }

    private void InitApiDigimon(){
        DigimonApiService service = new DigimonApiService();
        service.getDigimonModelList().enqueue(new Callback<List<DigimonModel>>() {
            @Override
            public void onResponse(Call<List<DigimonModel>> call, Response<List<DigimonModel>> response) {
                Log.v("response",String.valueOf(response.body().size()));
                digimonAdapter.setMainData(response.body());

            }

            @Override
            public void onFailure(Call<List<DigimonModel>> call, Throwable t) {
                Log.e("eror",t.getMessage());
            }
        });
    }
}