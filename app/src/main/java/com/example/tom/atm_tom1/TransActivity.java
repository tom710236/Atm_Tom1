package com.example.tom.atm_tom1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TransActivity extends AppCompatActivity {
    //先OkHttpClient類別屬性 提供了HTTP網路連線的功能
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        //使用Request.Builder()設定一個連線必要的資訊
        //如網址則使用url()方法定義 完成後再呼叫build方法產生HTTP的請求(Request),此時還未連線至主機
        Request request = new Request.Builder()
                .url("http://atm201605.appspot.com/h")
                .build();
        //使用newCall方法產生一個呼叫物件,此時還未連線至主機
        Call call = client.newCall(request);
        //呼叫enqueue方法進行排程連線,此時才連致主機 並在方法中準備一個回報的物件
        //成功回應onResponse
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("failLLLLLLLLLLL","");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.d("OKHTTP",json);
                parseJSON(json);
            }

            private void parseJSON(String json) {
            }

        });

    }
}
