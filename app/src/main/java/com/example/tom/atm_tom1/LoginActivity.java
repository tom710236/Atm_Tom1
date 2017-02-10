package com.example.tom.atm_tom1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //先以字串陣列方式將功能儲存在LoginActivity func陣列
    String [] func = {"餘額查詢","交易明細","最新消息","投資理財",
            "下一頁","離開"};

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
        //呼叫ListView的setAdapter設定adapter來啟動
        list.setAdapter(adapter);
        //事件處理-實作傾聽者介面 (alt+enter 加入Make 'MainActivity'....)
        list.setOnItemClickListener(this);


        //取得Spinner
        Spinner notify = (Spinner)findViewById(R.id.spinner);
        /*
        先準備字串陣列資料(values/array.xml)
        使用ArrayAdapter的類別方法creatFormResource直接產生一個
        ArratAdpter<CharSequence>
        參數1 Context(this) 參數2 陣列資源的ID值(R.arrat.notify_array)
        參數3 清單顯示時所用的版面配置
         */
        final ArrayAdapter<CharSequence> nadapter =
                ArrayAdapter.createFromResource(this,R.array.notify_array,
                        android.R.layout.simple_spinner_dropdown_item);
        //另外要改版面的話 可用setDropDownViewResource
        //nadapter.setDropDownViewResource(
                //android.R.layout.simple_spinner_dropdown_item);
        //將nadapter設定至Spinner元件中
        notify.setAdapter(nadapter);
        //選擇項目的事件處理(選擇清單的某一項目 來進行一些程式設計)
        /*
        AdapterView.OnItemSelectedListener(當項目選擇時的傾聽器)
        使用匿名類別設計
        當選擇某一項目 自動執行onItemSelected
        未選擇 執行onNothing Selected
         */
        notify.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(LoginActivity.this,
                                nadapter.getItem(position),
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

        /*
        欲取得Spinner元件中選擇的項目時 可使用 getSelectedItem
        回傳值Object 如果是字串可再呼叫toString
        String text = notify.getSelectedItem().toString();
         */


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
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case 5:
                finish();
                break;
        }
    }
}
