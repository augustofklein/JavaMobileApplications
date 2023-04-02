package br.ucs.android.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProductDB";
    private static final String TABLE_PRODUCTS = "products";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String[] COLUMNS = {ID, NAME, DESCRIPTION, PRICE};
    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE products ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT,"+
                "desctiption TEXT,"+
                "price DOUBLE)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS products");
        this.onCreate(db);
    }

    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, product.getName());
        values.put(DESCRIPTION, product.getDescription());
        values.put(PRICE, new Double(product.getPrice()));
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTS, // a. table
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
            Product product = cursorToProduct(cursor);
            return product;
        }
    }

    private Product cursorToProduct(Cursor cursor) {
        Product product = new Product();
        product.setId(Integer.parseInt(cursor.getString(0)));
        product.setName(cursor.getString(1));
        product.setDescription(cursor.getString(2));
        product.setPrice(Double.parseDouble(cursor.getString(3)));
        return product;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> productsList = new ArrayList<Product>();
        String query = "SELECT * FROM " + TABLE_PRODUCTS

                + " ORDER BY " + NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Product product = cursorToProduct(cursor);
                productsList.add(product);
            } while (cursor.moveToNext());
        }
        return productsList;
    }

    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, product.getName());
        values.put(DESCRIPTION, product.getDescription());
        values.put(PRICE, new Double(product.getPrice()));
        int i = db.update(TABLE_PRODUCTS,
                values,
                ID + " = ?",
                new String[]
                        { String.valueOf(product.getId()) });
        db.close();
        return i; // number the lines changed
    }

    public int deleteProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_PRODUCTS,
                ID + " = ?",
                new String[]
                        { String.valueOf(product.getId()) });
        db.close();
        return i; // number of columns deleted
    }

}