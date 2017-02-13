package com.example.tom.atm_tom1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TOM on 2017/2/13.
 */
    /*  Android 提供一個已經實作好的SQLiteOpenHelper類別 當應用程式需要使用
        SQLite資料庫時 只需要設計一個新類別並繼承SQLiteOpenHelper
        這個類別及具有存取資料庫的能力
    */

public class MyDBHelper extends SQLiteOpenHelper{
    //並未實作無參數的建構子因此必須設計建構子
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //SQLiteOpenHelper是抽象類別 其子類別必須實作必要方法 alt+enter
    @Override
    //SQLiteDatabase類別的用途在存取SQLite資料庫
    /*
    getReadableDatabase()方法:讀取 查詢
    getWritableDatabase()方法:更新能力 新增 修改 刪除
     */
    //建立資料表格的時機 - onCreate
    //應用程式執行到有關任何存取資料庫的指令時
    //假如資料庫不存在就會立刻執行本方法
    public void onCreate(SQLiteDatabase db) {
        //建立exp SQL語法 (呼叫execSQL方法建立exp表格)
        db.execSQL("CREATE  TABLE main.exp " +
                "(_id INTEGER PRIMARY KEY  NOT NULL , " +
                "cdate DATETIME NOT NULL , " +
                "info VARCHAR, " +
                "amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
