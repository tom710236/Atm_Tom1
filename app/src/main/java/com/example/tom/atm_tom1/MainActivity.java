package com.example.tom.atm_tom1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//此版本使用startActivity
public class MainActivity extends AppCompatActivity {
    //宣告
    EditText edtId,edtPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //先取得畫面上的帳號元件EditText 名稱為edUseid
        EditText edUId = (EditText) findViewById(R.id.Id);
        //取得儲存設定物件setting
        SharedPreferences setting =
                getSharedPreferences("atm",MODE_PRIVATE);
        //設定uId的預設值
        edUId.setText(setting.getString("uId",""));
    }
    //登入鍵
    public void onCLick (View v){
        //取得
        edtId = (EditText)findViewById(R.id.Id);
        edtPw = (EditText)findViewById(R.id.passWd);
        //取得EditText上的字串
        String uId=edtId.getText().toString();
        String uWd = edtPw.getText().toString();
        //假如uId OR uWd 上 無輸入資料時顯示AlertDialog提醒
        if(uId.length()==0||uWd.length()==0){
            new AlertDialog.Builder(this).setMessage("請輸入帳號或密碼")
                    .setTitle("提醒")
                    .setPositiveButton("ok",null)
                    .show();
        }
        //否則
        else{
            //假如uId為Tom uWd為1234 TOAST顯示登入成功 並進入登入畫面
            if(uId.equals("Tom")&&uWd.equals("1234")){
                //SharedPreferences可以將簡單資料儲存在手機中
                /*
                  呼叫getSharedPreferences的方法 產生一個檔名 atm.xml的設定
                  儲存檔 並只供本專案讀取 物件名稱setting
                 */
                SharedPreferences setting = // 取得儲存設定物件setting
                        getSharedPreferences("atm",MODE_PRIVATE);
                /*
                呼叫edit方法取得編譯器物件 使用匿名方法呼叫putString()
                方法將uId字串的內容寫入設定檔 資料標籤為"uId"
                最後呼叫commit()寫入到設定檔
                */
                setting.edit()
                        .putString("uId",uId)
                        .commit();
                Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);

            }
            //否則Toast顯示登入失敗 請重新輸入
            else{
                Toast.makeText(this,"登入失敗 請重新輸入",Toast.LENGTH_LONG).show();
            }
        }
    }
    //取消鍵
    public void onClick2(View v){
        finish();
    }

}