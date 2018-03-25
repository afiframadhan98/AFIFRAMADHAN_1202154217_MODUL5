package com.example.android.afiframadhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class DatabaseSQL extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;      // Versi Database
    private static final String DATABASE_NAME = "db_modul5";        // Nama Database
    private static final String TABLE_NAME = "tb_todo";         // Nama Database Table

    private static final String KEY_ID = "id";          // Kolom Id
    private static final String KEY_NAME = "name";      // Kolom Name
    private static final String KEY_DESC = "desc";      // Kolom Desc
    private static final String KEY_PRIORITY = "priority";      // Kolom Priority

    public DatabaseSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {           // Method untuk membuat Database Table
        String CREATE_TODO_TABLE = "CREATE TABLE " + TABLE_NAME + "("           // Membuat variabel yang berisi perintah
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"        // Untuk membuat Sebuah Table di Database
                + KEY_DESC + " TEXT, " + KEY_PRIORITY + " TEXT)";
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }


    public void save(ToDo todo){
        SQLiteDatabase db = this.getWritableDatabase();     // Membuat dan assign variabel dari Object SQLiteDatabase
        ContentValues values = new ContentValues();         // Membuat object ContentValues
        values.put(KEY_NAME, todo.getName());           // Menyimpan data Nama Todo
        values.put(KEY_DESC, todo.getDescription());        // Menyimpan data Deskripsi dari Todo
        values.put(KEY_PRIORITY, todo.getPriority());       // Menyimpan data Prioritas dari Todo

        db.insert(TABLE_NAME, null, values);        // Data-data tersebut dimasukkan kedalam Database Table
        db.close();         // Database Table closed
    }

    public LinkedList<ToDo> findAll(){
        LinkedList<ToDo> listBuku = new LinkedList<ToDo>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                ToDo todo = new ToDo();
                todo.setId(Integer.valueOf(cursor.getString(0)));
                todo.setName(cursor.getString(1));
                todo.setDescription(cursor.getString(2));
                todo.setPriority(cursor.getString(3));
                listBuku.add(todo);
            }

            while(cursor.moveToNext());
        }

        return listBuku;
    }

    public boolean delete(ToDo todo){
        SQLiteDatabase db = this.getWritableDatabase();     // Membuat dan assign variabel dari Object SQLiteDatabase
        return db.delete(TABLE_NAME, "id =" + todo.getId(), null) > 0;      // Delete Data Tabel
    }
}
