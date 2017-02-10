package com.example.tom.atm_tom1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //先以字串陣列方式將功能儲存 func陣列
    String [] func = {"餘額查詢","交易明細","最新消息","投資理財"
            ,"下一頁","離開"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //取得GridView
        GridView grid = (GridView)findViewById(R.id.grid);
        //當資料來源為字串陣列 可以使用ArrayAdapter
        /*
        第一個參數 Context(this),第二個參數 單列項目的設計圖(使用SDK提供的版面),
        第三個參數 本例的字串陣列
         */
        ArrayAdapter gAdater =
                new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
        //呼叫ListView的setAdapter設定adapter來啟動
        grid.setAdapter(gAdater);
        //事件處理-實作傾聽者介面 讓按鍵有作用 (alt+enter 加入Make 'MainActivity'....)
        grid.setOnItemClickListener(this);
    }
    //事件處理-實作傾聽者介面的必要方法 參數是position即是按下項目的索引值
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Intent intent = new Intent(this,Main3Activity.class);
                startActivity(intent);
                break;
            case 5:
                finish();
                break;
        }
    }
}
