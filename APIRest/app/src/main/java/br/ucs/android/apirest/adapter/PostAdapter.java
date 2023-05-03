package br.ucs.android.apirest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.ucs.android.apirest.R;
import br.ucs.android.apirest.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    private List<Post> posts;
    private int rowLayout;
    private Context context;

    public class PostViewHolder extends RecyclerView.ViewHolder {
        LinearLayout postsLayout;
        TextView postTitle;
        TextView postBody;

        public PostViewHolder(View v) {
            super(v);
            postsLayout = (LinearLayout) v.findViewById(R.id.posts_layout);
            postTitle = (TextView) v.findViewById(R.id.title);
            postBody = (TextView) v.findViewById(R.id.body);
        }
    }

    public PostAdapter(List<Post> posts, int rowLayout, Context context) {
        this.posts = posts;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PostViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {
        holder.postTitle.setText(posts.get(position).getTitle());
        holder.postBody.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}