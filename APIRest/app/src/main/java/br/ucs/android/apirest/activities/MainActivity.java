package br.ucs.android.apirest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import br.ucs.android.apirest.R;
import br.ucs.android.apirest.adapter.PostAdapter;
import br.ucs.android.apirest.model.Post;
import br.ucs.android.apirest.model.PostsResponse;
import br.ucs.android.apirest.rest.ApiInterface;
import br.ucs.android.apirest.rest.ApiPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.posts_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiPost.getPost().create(ApiInterface.class);

        Call<List<PostsResponse>> call = apiService.getAllPosts();
        call.enqueue(new Callback<List<PostsResponse>>() {
            @Override
            public void onResponse(Call<List<PostsResponse>> call, Response<PostsResponse> response) {
                int statusCode = response.code();
                List<Post> posts = response.body().getResults();
                recyclerView.setAdapter(new PostAdapter(posts, R.layout.list_item_post, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<PostsResponse>> call, Throwable t) {
                mostraAlerta("Erro", t.toString());
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    private void mostraAlerta(String titulo, String mensagem) {
        AlertDialog alertDialog = new
                AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(titulo);
        alertDialog.setMessage(mensagem);
        alertDialog.setButton(AlertDialog. BUTTON_NEUTRAL ,
                getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}