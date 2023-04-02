package br.ucs.android.bookdatabase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditBookActivity extends AppCompatActivity {
    private BDSQLiteHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelper(this);
        Book book = bd.getBook(id);
        final EditText name = (EditText) findViewById(R.id.edName);
        final EditText author = (EditText) findViewById(R.id.edAuthor);
        final EditText year = (EditText) findViewById(R.id.edYear);
        name.setText(book.getTitle());
        author.setText(book.getAuthor());
        year.setText(String.valueOf(book.getYear()));
        final Button edit = (Button) findViewById(R.id.btnUpdate);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setId(id);
                book.setTitle(name.getText().toString());
                book.setAuthor(author.getText().toString());
                book.setYear(Integer.parseInt(year.getText().toString()));
                bd.updateBook(book);
                Intent intent = new Intent(EditBookActivity.this,

                        MainActivity.class);
                startActivity(intent);
            }
        });

        final Button remove = (Button) findViewById(R.id.btnRemove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(EditBookActivity.this)
                        .setTitle(R.string.confirmar_exclusao)
                        .setMessage(R.string.quer_mesmo_apagar)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes,
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Book book = new Book();
                                        book.setId(id);
                                        bd.deleteBook(book);
                                        Intent intent = new Intent(EditBookActivity.this,

                                                MainActivity.class);
                                        startActivity(intent);
                                    }
                                })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }
}
