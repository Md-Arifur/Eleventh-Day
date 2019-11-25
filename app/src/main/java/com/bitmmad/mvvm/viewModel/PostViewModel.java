package com.bitmmad.mvvm.viewModel;

import android.app.Application;

import com.bitmmad.mvvm.model.Post;
import com.bitmmad.mvvm.repository.PostRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class PostViewModel extends AndroidViewModel {

    private PostRepo postRepo;
    public PostViewModel(@NonNull Application application) {
        super(application);
        postRepo = new PostRepo(application);
    }


    public MutableLiveData<List<Post>> getPostList(){
        return postRepo.getPostList();
    }
}
