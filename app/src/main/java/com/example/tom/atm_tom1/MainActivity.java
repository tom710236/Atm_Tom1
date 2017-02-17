package com.example.tom.atm_tom1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

//此版本使用startActivity
public class MainActivity extends AppCompatActivity {
    //宣告
    EditText edtId,edtPw;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //先取得畫面上的帳號元件EditText 名稱為edUseid
        EditText edUId = (EditText) findViewById(R.id.Id);
        //取得儲存設定物件setting
        SharedPreferences setting =
                getSharedPreferences("reID",MODE_PRIVATE);
        //設定uId的預設值
        edUId.setText(setting.getString("uId",""));
    }
    //登入鍵
    public void onCLick (View v){
        //取得
        edtId = (EditText)findViewById(R.id.Id);
        edtPw = (EditText)findViewById(R.id.passWd);
        //取得EditText上的字串
        String uId = edtId.getText().toString();
        String uWd = edtPw.getText().toString();
        String url = new StringBuilder(
                "http://atm201605.appspot.com/login?uid=")
                .append(uId)
                .append("&pw=")
                .append(uWd)
                .toString();
        new LoginTask().execute(url);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //取消鍵
    public void onClick2(View v){
        finish();
    }

    //網路連線登入的AsyncTask類別
    //參數第一個為傳入型態 欲傳入一網址 所以使用String
    //第二個因為連線時間不長 不須回傳資料
    //第三個判斷網頁回應是1或2 回傳登入是否成功的布林值
    class LoginTask extends AsyncTask<String,Void,Boolean>{

        //連線完成後仍需要設計給使用者的回應
        @Override
        protected void onPostExecute(Boolean logon) {
            super.onPostExecute(logon);
            if (logon){
                Toast.makeText(MainActivity.this,"登入成功",
                        Toast.LENGTH_LONG).show();
                setResult(RESULT_OK,getIntent());
                //登入成功後 進入LoginActivity
                intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }else {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("ATM")
                        .setMessage("登入失敗")
                        .setPositiveButton("ok",null)
                        .show();
            }
        }

        @Override
        //產生java.net.URL 並連線讀取一個字元
        //讀取到1字元時 其Unicode值為49 代表登入成功
        //在doInBackground方法中實作登入成功與失敗的對應
        protected Boolean doInBackground(String... params) {
            boolean logon = false;
            try {
                URL url = new URL (params[0]);
                InputStream is = url.openStream();
                int data = is.read();
                Log.d("Http",String.valueOf(data));
                if(data == 49){
                    logon = true;
                }
                is.close();
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return logon;
        }

    }




}
