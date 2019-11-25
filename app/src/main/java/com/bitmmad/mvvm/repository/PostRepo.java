package com.bitmmad.mvvm.repository;

import android.app.Application;

import com.bitmmad.mvvm.model.Post;
import com.bitmmad.mvvm.retrofit.ApiService;
import com.bitmmad.mvvm.retrofit.RetrofitInstance;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostRepo {
    private Application application;
    private ApiService apiService;

    public PostRepo(Application application) {
        this.application = application;
        apiService = RetrofitInstance.getInstance().create(ApiService.class);
    }

    public MutableLiveData<List<Post>> getPostList(){
        final MutableLiveData<List<Post>> liveData = new MutableLiveData<>();

        Call<List<Post>> call = apiService.getPostList();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response!=null){
                    List<Post> postList = response.body();
                    liveData.postValue(postList);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });


        return liveData;
    }
}
