package com.example.christian.proyectofin_pmm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christian on 17/02/2018.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kebaberia";
    private static final int DATABASE_VERSION = 7;

    public static final String TABLE_NAME = "pedidos";
    public static final String COLUMN_ID =  "pedidoid";
    public static final String COLUMN_NAME =  "kebab";
    public static final String COLUMN_DESC =  "descripcion";
    public static final String COLUMN_PRECIO =  "precio";

    private static final String CREATE_TABLE_PEDIDOS =
            "CREATE TABLE " + TABLE_NAME+ " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, "+
                    COLUMN_DESC + " TEXT, " +
                    COLUMN_PRECIO + " INTEGER " + ")";

    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PEDIDOS);

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_NAME + " ('kebab','descripcion','precio') VALUES" +
                "('Kebab','de Ternera',3)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void close(){
        this.close();
    }
}
