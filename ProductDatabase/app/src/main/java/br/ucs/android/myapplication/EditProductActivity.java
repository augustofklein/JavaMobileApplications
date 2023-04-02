package br.ucs.android.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditProductActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelper(this);
        Product product = bd.getProduct(id);
        final EditText name = (EditText) findViewById(R.id.edName);
        final EditText description = (EditText) findViewById(R.id.edDescription);
        final EditText price = (EditText) findViewById(R.id.edPrice);
        name.setText(product.getName());
        description.setText(product.getDescription());
        price.setText(String.valueOf(product.getPrice()));
        final Button edit = (Button) findViewById(R.id.btnUpdate);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setId(id);
                product.setName(name.getText().toString());
                product.setDescription(description.getText().toString());
                product.setPrice(Double.parseDouble(price.getText().toString()));
                bd.updateProduct(product);
                Intent intent = new Intent(EditProductActivity.this,
                                           MainActivity.class);
                                           startActivity(intent);
            }
        });

        final Button remove = (Button) findViewById(R.id.btnRemove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(EditProductActivity.this)
                        .setTitle(R.string.confirm_deletion)
                        .setMessage(R.string.really_want_to_delete)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Product product = new Product();
                                        product.setId(id);
                                        bd.deleteProduct(product);
                                        Intent intent = new Intent(EditProductActivity.this,
                                                                   MainActivity.class);
                                                                   startActivity(intent);
                                    }
                                })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }

}
