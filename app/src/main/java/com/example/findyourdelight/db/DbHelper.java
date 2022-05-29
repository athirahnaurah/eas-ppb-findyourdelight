package com.example.findyourdelight.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.findyourdelight.models.Result;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "menu";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_MENUS = "menu";
    private static final String KEY_ID = "id";
    private static final String KEY_MENUNAME = "menuname";
    private static final String KEY_DESCRIPTION = "description";

    private static final String CREATE_TABLE_MENUS = "CREATE TABLE " + TABLE_MENUS +
            " ( " + KEY_ID + " TEXT , " + KEY_MENUNAME + " TEXT, " +
            KEY_DESCRIPTION + " TEXT);";

    private static final String DROP_TABLE_MENUS = "DROP TABLES " + TABLE_MENUS;

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MENUS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLE_MENUS + "'");
        onCreate(sqLiteDatabase);
    }

    public long addMenuDetail(String id, String menuname, String description){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_MENUNAME, menuname);
        values.put(KEY_DESCRIPTION, description);

        long insert = sqLiteDatabase.insert(TABLE_MENUS, null, values);

        return insert;
    }

    public void deleteMenu(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_MENUS, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public boolean checkMenu(String id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String findQuery = "SELECT * FROM " + TABLE_MENUS + " WHERE id=" + id;
        Cursor c = sqLiteDatabase.rawQuery(findQuery, null);
        if (c.getCount() <= 0){
            c.close();
            return false;
        }
        c.close();
        return true;
    }

    @SuppressLint("Range")
    public ArrayList<Result> getAllMenus(){
        ArrayList<Result> menuModelArrayList = new ArrayList<Result>();

        String selectQuery = "SELECT * FROM " + TABLE_MENUS;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(selectQuery, null);

        if (c.moveToFirst()){
            do {
                Result mv = new Result();

                mv.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                mv.setMenuname(c.getString(c.getColumnIndex(KEY_MENUNAME)));
                mv.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));

                menuModelArrayList.add(mv);
            } while (c.moveToNext());
        }

        return menuModelArrayList;
    }
}
