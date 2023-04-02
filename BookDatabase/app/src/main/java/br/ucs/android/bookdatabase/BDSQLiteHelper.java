package br.ucs.android.bookdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BookDB";
    private static final String TABLE_BOOKS = "books";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String YEAR = "year";
    private static final String[] COLUMNS = {ID, TITLE, AUTHOR, YEAR};
    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE books ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "title TEXT,"+
                "author TEXT,"+
                "year INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(db);
    }

    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, book.getTitle());
        values.put(AUTHOR, book.getAuthor());
        values.put(YEAR, new Integer(book.getYear()));
        db.insert(TABLE_BOOKS, null, values);
        db.close();
    }

    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BOOKS, // a. table
                COLUMNS, // b. columns
                " id = ?", // c. columns to compare
                new String[] { String.valueOf(id) }, // d. parameters
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            Book book = cursorToBook(cursor);
            return book;
        }
    }

    private Book cursorToBook(Cursor cursor) {
        Book book = new Book();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setTitle(cursor.getString(1));
        book.setAuthor(cursor.getString(2));
        book.setYear(Integer.parseInt(cursor.getString(3)));
        return book;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        String query = "SELECT * FROM " + TABLE_BOOKS

                + " ORDER BY " + TITLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Book book = cursorToBook(cursor);
                booksList.add(book);
            } while (cursor.moveToNext());
        }
        return booksList;
    }

    public int updateBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, book.getTitle());
        values.put(AUTHOR, book.getAuthor());
        values.put(YEAR, new Integer(book.getYear()));
        int i = db.update(TABLE_BOOKS,
                values,
                ID + " = ?",
                new String[]
                        { String.valueOf(book.getId()) });
        db.close();
        return i; // number the lines changed
    }

    public int deleteBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_BOOKS,
                ID + " = ?",
                new String[]
                        { String.valueOf(book.getId()) });
        db.close();
        return i; // number of columns deleted
    }
}
