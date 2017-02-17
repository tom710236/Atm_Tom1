package com.example.tom.atm_tom1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

//實感設計的基本活動
//查詢exp資料表格,並將查詢結果以ListView清單元件展示
public class FinanceActivity extends AppCompatActivity {
    //宣告
    ListView list;
    MyDBHelper helper;
    Cursor c;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //取得
        list = (ListView)findViewById(R.id.list);
        //產生MyDBHelper物件 並查詢exp表格
        //helper = new MyDBHelper(this,"expense.db",null,1);
        helper = MyDBHelper.getInstance(this);//防資料庫被鎖死
        //呼叫MyDBHelper建構子得到物件在查詢 最後得到Cursor物件
        c=helper.getReadableDatabase().query("exp",null,null,null,null,null,null);
        //Adapter曾介紹ListView的資料來源若是查詢結果為Cursor
        //可使用SimpleCursorAdapter建立Adapter物件
        /*
        SimpleCursorAdapter(Context context(this),
        int layout(清單元件中的版面配置資源),
        Cursor c(經過查詢語法得到的Cursor物件)
        String[]from 資料來源的欄位名稱字串陣列 查詢結果Cursor物件中的欄位資料
        int[]to 畫面中的資源ID陣列
         */
        adapter = new SimpleCursorAdapter(this,
                //android.R.layout.simple_expandable_list_item_2,
                R.layout.finance_row,
                c,
                //new String[] {"info","amount"},
                new String[] {"_id","cdate","info","amount"},
                //new int[] {android.R.id.text1,android.R.id.text2},
                new int[] {R.id.item_id,R.id.item_cdate,R.id.item_info,R.id.item_amount},
                0);
        //將adapter設定給list清單元件
        list.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            //按下投資畫面可啟動FinanceActivity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinanceActivity.this,addActivity.class);
                startActivity(intent);
                //另一種寫法
                // startActivity(new Intent(FinanceActivity.this,addActivity.class));

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });
    }

}
