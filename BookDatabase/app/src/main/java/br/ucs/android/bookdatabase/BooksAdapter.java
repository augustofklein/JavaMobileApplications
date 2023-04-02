package br.ucs.android.bookdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BooksAdapter extends ArrayAdapter<Book> {
    private final Context context;
    private final ArrayList<Book> elements;
    public BooksAdapter(Context context, ArrayList<Book> elements) {
        super(context, R.layout.line, elements);
        this.context = context;
        this.elements = elements;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.line, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.txtNome);
        TextView year = (TextView) rowView.findViewById(R.id.txtAno);
        TextView author = (TextView) rowView.findViewById(R.id.txtAutor);
        title.setText(elements.get(position).getTitle());
        author.setText(elements.get(position).getAuthor());
        year.setText(Integer.toString(elements.get(position).getYear()));
        return rowView;
    }
}