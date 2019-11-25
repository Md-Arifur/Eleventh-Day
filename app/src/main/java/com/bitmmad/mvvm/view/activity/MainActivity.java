package com.bitmmad.mvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.bitmmad.mvvm.R;
import com.bitmmad.mvvm.model.Post;
import com.bitmmad.mvvm.viewModel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        getPostList();
    }


    private void getPostList() {
        postViewModel.getPostList().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                if (posts!=null && posts.size()>0){

                }
            }
        });
    }
}
