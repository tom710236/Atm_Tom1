package com.example.tom.atm_tom1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.tom.atm_tom1.R.layout.item_row;
/*
客製化功能表
    準備功能圖示檔案:1.google開放源碼下載
                     2.放進res/drawable
 */

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //先以字串陣列方式將功能儲存 func陣列
    //以整數陣列方式將功能圖示儲存 icons
    String [] func = {"餘額查詢","交易明細","最新消息","投資理財"
            ,"上一頁","離開"};
    int [] icons = {R.drawable.g,R.drawable.b,R.drawable.c
    ,R.drawable.d,R.drawable.e,R.drawable.f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //取得
        GridView grid = (GridView)findViewById(R.id.grid);
        //建立IconAdapter物件
        IconAdapter gAdapter = new IconAdapter();
        //執行IconAdapter
        grid.setAdapter(gAdapter);
        //事件處理-實作傾聽者介面 讓按鍵有作用 (alt+enter 加入Make 'MainActivity'....)
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch ((int)id){
            case R.drawable.g:
                break;
            case R.drawable.b:
                break;
            case R.drawable.c:
                break;
            case R.drawable.d:
                break;
            case R.drawable.e:
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.drawable.f:
                finish();
                break;
        }
    }

    /*
    內部類別設計
    設計一個新類別並繼承BaseAdpter(因為為抽象類別 所以需
    實作四個方法...alt+enter)
     */
    class IconAdapter extends BaseAdapter{

        @Override
        //回傳GridView中項目的個數(使用陣列的數量值回傳)
        public int getCount() {
            return func.length;
        }

        @Override
        //回傳參數postion所對應的資源(使用功能項目的字串)
        public Object getItem(int position) {
            return func[position];
        }

        @Override
        //回傳position所對應的id值 可供辨識不重複
        public long getItemId(int position) {
            return icons[position];
        }
        /*
        當GridView或其他清單元件在畫面中欲展示一個項目給
        使用者時,會使用此方法
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
            convertView即是目前呼叫方手上有的View元件
            第一次呼叫時傳入的converView是null值
            應該在converView值時產生一個合適的View元件給呼叫方
            View元件應依照傳入的position產生相對應的功能項目
            他的版面配置檔就是之前設計的res/layout/item_row.xml
             */

            View v = convertView;
            if(v == null){
                /*
                getLayoutInflater方法取得LayoutInflater物件
                在使用他的inflate方法由版面檔R.layout.item_row
                建立一實際View物件
                 */
                v =getLayoutInflater().inflate(item_row,null);
                ImageView image = (ImageView)v.findViewById(R.id.item_image);
                TextView text = (TextView)v.findViewById(R.id.item_text);
                //呼叫setImageResource方法設定圖示的圖檔資源
                image.setImageResource(icons[position]);
                //呼叫setText方法設定圖示上的文字
                text.setText(func[position]);
            }
            return v;
        }


    }
}
