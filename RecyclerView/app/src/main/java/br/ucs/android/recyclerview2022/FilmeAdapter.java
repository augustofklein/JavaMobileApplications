package br.ucs.android.recyclerview2022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {

    private List<Filme> filmes;

    public FilmeAdapter(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.setData(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtFase;
        private TextView txtAno;
        private TextView txtTitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtFase = itemView.findViewById(R.id.txtFase);
            txtAno = itemView.findViewById(R.id.txtAno);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
        }

        private void setData(Filme filme) {
            txtFase.setText(new Integer(filme.getFase()).toString());
            txtAno.setText(new Integer(filme.getAno()).toString());
            txtTitulo.setText(filme.getTitulo());

        }

        public void onClick(View view) {
            Snackbar.make(view, "Você selecionou " + filmes.get(getLayoutPosition()).getTitulo(), Snackbar.LENGTH_SHORT).show();
        }
    }
}
