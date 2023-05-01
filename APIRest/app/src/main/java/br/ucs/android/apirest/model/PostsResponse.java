package br.ucs.android.apirest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostsResponse {

    @SerializedName("results")
    private List<Post> results;

    public void setResults(List<Post> results) {
        this.results = results;
    }

    public List<Post> getResults() {
        return results;
    }

}
