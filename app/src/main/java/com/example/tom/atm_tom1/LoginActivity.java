package com.example.tom.atm_tom1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LoginActivity extends AppCompatActivity {
    //先以字串陣列方式將功能儲存在LoginActivity func陣列
    String [] func = {"餘額查詢","交易明細","最新消息","投資理財",
            "離開"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //取得ListView
        ListView list = (ListView)findViewById(R.id.list);
        //當資料來源為字串陣列 可以使用ArrayAdapter
        /*
        第一個參數 Context(this),第二個參數 單列項目的設計圖(使用SDK提供的版面),
        第三個參數 本例的字串陣列
         */
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
        //
        list.setAdapter(adapter);

    }
}
