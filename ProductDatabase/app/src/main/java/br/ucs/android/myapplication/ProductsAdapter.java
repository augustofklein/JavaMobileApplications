package br.ucs.android.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> elements;
    public ProductsAdapter(Context context, ArrayList<Product> elements) {
        super(context, R.layout.line, elements);
        this.context = context;
        this.elements = elements;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.line, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.txtName);
        TextView year = (TextView) rowView.findViewById(R.id.txtDescription);
        TextView author = (TextView) rowView.findViewById(R.id.txtPrice);
        title.setText(elements.get(position).getName());
        author.setText(elements.get(position).getDescription());
        year.setText(Double.toString(elements.get(position).getPrice()));
        return rowView;
    }

}
