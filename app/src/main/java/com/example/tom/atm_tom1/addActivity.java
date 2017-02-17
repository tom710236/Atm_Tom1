package com.example.tom.atm_tom1;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class addActivity extends AppCompatActivity {
    //宣告
    private EditText edDate;
    private EditText edInfo;
    private EditText edAmount;
    private MyDBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //取得
        edDate = (EditText)findViewById(R.id.ed_date);
        edInfo = (EditText)findViewById(R.id.ed_info);
        edAmount = (EditText)findViewById(R.id.ed_amount);
        //呼叫MyDBHelper的建構子建立物件
        /*
        MyDBHelper(Context context,String name,CursorFactory factory,int version)
                  (this(傳入addActivity),資料庫檔案名稱(自訂),標準模式處理(null),目前資料庫版本(1代表第一個版本))
         */
        //helper = new MyDBHelper(this,"expense.db",null,1);
        helper = MyDBHelper.getInstance(this);//防資料庫被鎖死
    }
    //將消費紀錄儲存在一個ContentValues物件 再呼叫SQLiteDatabase
    //的insert方法新增紀錄
    public void add(View v){
        //取得資料
        String cdate = edDate.getText().toString();
        String info = edInfo.getText().toString();
        //產生並收集一筆紀錄的集合
        int amount = Integer.parseInt(edAmount.getText().toString());
        ContentValues values = new ContentValues();
        values.put("cdate", cdate);
        values.put("info", info);
        values.put("amount", amount);
        //呼叫insert傳入表格名稱與values集合物件以新增這筆紀錄
        long id = helper.getWritableDatabase().insert("exp", null, values);
        Log.d("ADD", id+"");
    }
}
