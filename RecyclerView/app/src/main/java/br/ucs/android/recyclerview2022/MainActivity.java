package br.ucs.android.recyclerview2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme(1, 1, 1, "Homem de Ferro", 2008));
        filmes.add(new Filme(2, 1, 2, "O Incrível Hulk", 2008));
        filmes.add(new Filme(3, 1, 3, "Homem de Ferro 2", 2010));
        filmes.add(new Filme(4, 1, 4, "Thor", 2011));
        filmes.add(new Filme(5, 1, 5, "Capitão América: O Primeiro Vingador", 2011));
        filmes.add(new Filme(6, 1, 6, "Os Vingadores", 2012));

        filmes.add(new Filme(7, 2, 1, "Homem de Ferro 3", 2013));
        filmes.add(new Filme(8, 2, 2, "Thor: O Mundo Sombrio", 2013));
        filmes.add(new Filme(9, 2, 3, "Capitão América 2: O Soldado Invernal", 2014));
        filmes.add(new Filme(10, 2, 4, "Guardiões da Galáxia", 2014));
        filmes.add(new Filme(11, 2, 5, "Vingadores: Era de Ultron", 2015));
        filmes.add(new Filme(12, 2, 6, "Homem-Formiga", 2015));

        filmes.add(new Filme(13, 3, 1, "Capitão América,Guerra Civil", 2016));
        filmes.add(new Filme(14, 3, 2, "Doutor Estranho", 2016));
        filmes.add(new Filme(15, 3, 3, "Guardiões da Galáxia Vol. 2", 2017));
        filmes.add(new Filme(16, 3, 4, "Homem-Aranha: De Volta Ao Lar", 2017));
        filmes.add(new Filme(17, 3, 5, "Thor: Ragnarok", 2017));
        filmes.add(new Filme(18, 3, 6, "Pantera Negra", 2018));
        filmes.add(new Filme(19, 3, 7, "Vingadores: Guerra Infinita", 2018));
        filmes.add(new Filme(20, 3, 8, "Homem-Formiga e a Vespa", 2018));
        filmes.add(new Filme(21, 3, 9, "Capitã Marvel", 2019));
        filmes.add(new Filme(22, 3, 10, "Vingadores: Ultimato", 2019));
        filmes.add(new Filme(23, 3, 11, "Homem-Aranha: Longe de Casa", 2019));

        filmes.add(new Filme(24, 4, 1, "Viúva-negra", 2021));
        filmes.add(new Filme(25, 4, 2, "Os Eternos", 2021));
        filmes.add(new Filme(26, 4, 3, "Shang-Chi e a Lenda dos Dez Anéis", 2021));
        filmes.add(new Filme(27, 4, 4, "Homem-Aranha: Sem Volta para Casa", 2021));
        filmes.add(new Filme(28, 4, 5, "Doutor Estranho no Multiverso da Loucura", 2022));
        filmes.add(new Filme(29, 4, 6, "Thor: Love and Thunder", 2022));

        final FilmeAdapter adapter = new FilmeAdapter(filmes);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}