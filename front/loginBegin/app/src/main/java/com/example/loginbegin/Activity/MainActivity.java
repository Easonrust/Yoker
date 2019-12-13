package com.example.loginbegin.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.res.Configuration;

import com.example.loginbegin.R;
import com.example.loginbegin.Fragments.*;
import com.example.loginbegin.utils.AnalysisUtils;

public class MainActivity extends FragmentActivity implements OnClickListener {
    private RelativeLayout main_body;
    private RelativeLayout bottom_bar_translate_btn;
    private RelativeLayout bottom_bar_home_btn;
    private RelativeLayout bottom_bar_user_btn;

//    private TextView et_user_name;
//    // 翻译页面，用户页面
//    private RelativeLayout tv_translate, tv_home, tv_user;
//    private Intent userData;
//    private String userName;
////    private Button goto_translate;
//    SharedPreferences sprfMain;
//    SharedPreferences.Editor editorMain;

//
//    FragmentManager manager = getSupportFragmentManager();
//    FragmentTransaction transaction = manager.beginTransaction();
//    transaction.add(R.id.main_body, new CourseFragment()).commit();


//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        et_user_name = findViewById(R.id.et_user_name);
//        tv_translate = findViewById(R.id.bottom_bar_translate_btn);
//        tv_home = findViewById(R.id.bottom_bar_home_btn);
//        tv_user = findViewById(R.id.bottom_bar_user_btn);
//        userData = getIntent();
//        userName = userData.getStringExtra("userName");
////        goto_translate = findViewById(R.id.goto_translate);
//        sprfMain= PreferenceManager.getDefaultSharedPreferences(this);
//        editorMain=sprfMain.edit();
//
//        tv_translate.setOnClickListener(this);
////        goto_translate.setOnClickListener(this);
//    }
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //把Fragment加到Activity里的代码如下
        /* FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_body,new UserFragment()).commit(); */
        setMain();
    }

    private void setMain() {
        this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,new UserFragment()).commit();
    }

    private void initView() {
        main_body = findViewById(R.id.main_body);
        bottom_bar_translate_btn = findViewById(R.id.bottom_bar_translate_btn);
        bottom_bar_home_btn = findViewById(R.id.bottom_bar_home_btn);
        bottom_bar_user_btn = findViewById(R.id.bottom_bar_user_btn);

        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivityForResult(intent,1);

        bottom_bar_translate_btn.setOnClickListener(this);
        bottom_bar_home_btn.setOnClickListener(this);
        bottom_bar_user_btn.setOnClickListener(this);
    }



    //共享信息的函数，考虑重写
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            String userName = data.getStringExtra("userName");
            //if (!TextUtils.isEmpty(userName)){
            Toast.makeText(MainActivity.this,"登陆成功："+userName, Toast.LENGTH_SHORT).show();
//            et_user_name.setText(userName);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new UserFragment()).commit();

        }
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("ORIENTATION_LANDSCAPE=" + Configuration.ORIENTATION_LANDSCAPE);// 当前为横屏
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            System.out.println("ORIENTATION_PORTRAIT=" + Configuration.ORIENTATION_PORTRAIT);// 当前为竖屏
        }
        super.onConfigurationChanged(newConfig);
    }



    public void onClick(View v){
        switch (v.getId()){
            case R.id.bottom_bar_translate_btn:
                if (AnalysisUtils.readLoginStatus(this)) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new TranslateFragment()).commit();
                }else {
                    Toast.makeText(this, "Please log in first.", Toast.LENGTH_SHORT).show();
                }
//                Intent intent=new Intent(MainActivity.this,TranslateActivity.class);
//                startActivity(intent);
                break;
            case R.id.bottom_bar_home_btn:
                if (AnalysisUtils.readLoginStatus(this)) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new HomeFragment()).commit();
                }else {
                    Toast.makeText(this, "Please log in first.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bottom_bar_user_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,new UserFragment()).commit();
                break;
            default:
                break;
        }
    }

}
