package br.ucs.android.apirest.rest;

import java.util.List;

import br.ucs.android.apirest.model.Post;
import br.ucs.android.apirest.model.PostsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("posts/")
    Call<List<PostsResponse>> getAllPosts();

    @GET("posts/{id}")
    Call<List<PostsResponse>> getPost(@Path("id") int userId);

}