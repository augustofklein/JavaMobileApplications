package br.ucs.android.myapplication;

import android.content.Intent;
import android.hardware.display.DeviceProductInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        bd = new BDSQLiteHelper(this);
        final EditText name = (EditText) findViewById(R.id.edName);
        final EditText description = (EditText) findViewById(R.id.edDescription);
        final EditText price = (EditText) findViewById(R.id.edPrice);
        Button novo = (Button) findViewById(R.id.btnAdd);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product();
                product.setName(name.getText().toString());
                product.setDescription(description.getText().toString());
                product.setPrice(Double.parseDouble(price.getText().toString()));
                bd.addProduct(product);
                Intent intent = new Intent(ProductActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
