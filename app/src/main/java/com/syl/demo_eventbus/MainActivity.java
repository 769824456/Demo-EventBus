package com.syl.demo_eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

/*
 * PACKAGE_NAME :com.syl.demo_eventbus
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 7/31/2015 1:52 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * E-MAIL: yulongsun@hengtiansoft.com
 * NOTE :
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btnMainNextActivity;
    private TextView tvMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.注册EventBus
        EventBus.getDefault().register(this);

        //2.
        btnMainNextActivity = (Button) findViewById(R.id.btn_main_next_activity);
        tvMainContent = (TextView) findViewById(R.id.tv_main_content);
        btnMainNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onEvent(FirstEvent event) {
        Log.e("MainActivity", "onEvent==" + event.getMsg());
    }

    public void onEventMainThread(FirstEvent event) {
        String msg = "MainActivity：" + event.getMsg();
        Log.e(TAG, "onEventMainThread==" + msg);
        tvMainContent.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    public void onEventBackgroundThread(FirstEvent event) {
        Log.e(TAG, "onEventBackgroundThread==" + event.getMsg());
    }

    public void onEventAsync(FirstEvent event){
        Log.e(TAG,"onEventAsync=="+event.getMsg());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
