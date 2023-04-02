package br.ucs.android.bookdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {
    private BDSQLiteHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = new BDSQLiteHelper(this);
        final EditText name = (EditText) findViewById(R.id.edName);
        final EditText author = (EditText) findViewById(R.id.edAuthor);
        final EditText year = (EditText) findViewById(R.id.edYear);
        Button newButton = (Button) findViewById(R.id.btnAdd);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setTitle(name.getText().toString());
                book.setAuthor(author.getText().toString());
                book.setYear(Integer.parseInt(year.getText().toString()));
                bd.addBook(book);
                Intent intent = new Intent(BookActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
