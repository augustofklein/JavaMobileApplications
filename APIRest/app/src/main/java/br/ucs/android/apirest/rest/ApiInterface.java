package br.ucs.android.apirest.rest;

import java.util.List;

import br.ucs.android.apirest.model.Post;
import br.ucs.android.apirest.model.PostsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("users")
    Call<List<PostsResponse>> getAllPosts();

    @GET("users/{userId}")
    Call<PostsResponse> getPost(@Path("userId") int userId);

}
