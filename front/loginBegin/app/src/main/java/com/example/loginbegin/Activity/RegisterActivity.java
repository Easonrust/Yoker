package com.example.loginbegin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;
import android.text.TextUtils;
import android.content.Intent;
import android.content.SharedPreferences;

import okhttp3.*;

import com.example.loginbegin.R;
import com.example.loginbegin.utils.MD5Utils;
import com.example.loginbegin.model.dao.Constant;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    //标题
    private TextView tv_main_title;
    //返回按钮
    private TextView tv_back;
    //注册按钮
    private Button btn_register;
    //用户名，密码，再次输入的密码的控件
    private EditText et_user_name,et_psw,et_psw_again;
    //用户名，密码，再次输入的密码的控件的获取值
    private String userName,psw,pswAgain;
    //标题布局
    private RelativeLayout rl_title_bar;
    //用户名是否重复
    private boolean add_success=true;

    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局 ,注册界面
        setContentView(R.layout.activity_register);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

//        Handler handler=new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                switch (msg.what){
//                    case true:
//                        //在这里可以进行UI操作
//                        mText.setText("HelloJohnnyZhou");
//                        break;
//                    default:
//                        break;
//                }
//            }
//        };
    }

    private void init() {
        //从main_title_bar.xml 页面布局中获取对应的UI控件
        tv_main_title=findViewById(R.id.tv_main_title);
        tv_main_title.setText("Sign Up");
        tv_back=findViewById(R.id.tv_back);
        //布局根元素
        rl_title_bar=findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.TRANSPARENT);
        //从activity_register.xml 页面中获取对应的UI控件
        btn_register=findViewById(R.id.btn_register);
        et_user_name=findViewById(R.id.et_user_name);
        et_psw=findViewById(R.id.et_psw);
        et_psw_again=findViewById(R.id.et_psw_again);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //返回键
                RegisterActivity.this.finish();
            }
        });
        //注册按钮
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //获取输入在相应控件中的字符串
                getEditString();
                //判断输入框内容
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(RegisterActivity.this, "Please enter your username.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(RegisterActivity.this, "Please enter password.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(pswAgain)){
                    Toast.makeText(RegisterActivity.this, "Please enter password again.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!psw.equals(pswAgain)){
                    Toast.makeText(RegisterActivity.this, "Different passwords.", Toast.LENGTH_SHORT).show();
                    return;
                /** *从SharedPreferences中读取输入的用户名，判断SharedPreferences中是否有此用户名 */
                // Todo: SharedPreferences换成从数据库（后端）读取
                }else{
                    addUserInfo(userName, psw);
                    if(!add_success){
                        Toast.makeText(RegisterActivity.this, "This username is used.", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        Toast.makeText(RegisterActivity.this, "Succeed!", Toast.LENGTH_SHORT).show();
                        //把账号、密码和账号标识保存到sp里面
                        /** * 保存账号和密码到SharedPreferences中 */
                        // Todo: SharedPreferences换成存入数据库，向后端传数据

                        saveRegisterInfo(userName, psw);
                        //注册成功后把账号传递到LoginActivity.java中
                        // 返回值到loginActivity显示
                        Intent data = new Intent();
                        data.putExtra("userName", userName);
                        setResult(RESULT_OK, data);
                        //RESULT_OK为Activity系统常量，状态码为-1，
                        // 表示此页面下的内容操作成功将data返回到上一页面，如果是用back返回过去的则不存在用setResult传递data值
                        add_success=false;
                        RegisterActivity.this.finish();
                    }
                }
            }
        });
    }
    /** * 获取控件中的字符串 */
    private void getEditString(){
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
        pswAgain=et_psw_again.getText().toString().trim();
    }

    // Todo: 改成：SharedPreferences换成从数据库（后端）读取

    /** * 从SharedPreferences中读取输入的用户名，将用户信息插入，如果插入成功返回true，插入失败返回false重新输入 */
    private void addUserInfo(String userName, String psw){
//        boolean has_userName= false;

//        mode_private SharedPreferences sp = getSharedPreferences( );
        // "loginInfo", MODE_PRIVATE

        new Thread(new Runnable(){
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                HashMap<String,String> paramsMap=new HashMap<>();
                paramsMap.put("password", psw);
                paramsMap.put("name", userName);


                paramsMap.put("id","1");

                Gson gson=new Gson();
                String data=gson.toJson(paramsMap);


                RequestBody formBody;
                formBody=RequestBody.create(JSON,data);
                Request request=new Request.Builder().url(Constant.ADD).post(formBody).build();

                try (Response response = okHttpClient.newCall(request).execute()) {
                    Looper.prepare();
                    String answer = response.body().string();
                    Boolean t = Boolean.parseBoolean(answer);
                    add_success = t;
                    Looper.loop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        if(add_success){
            SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
            //获取密码
            String spPsw=sp.getString(userName, "");
            // 传入用户名获取密码
            // 如果密码不为空则确实保存过这个用户名

//        if(!TextUtils.isEmpty(spPsw)) {
//            has_userName=true;
//        }
//        return has_userName;

        }

    }

    private void saveRegisterInfo(String userName,String psw){
        String md5Psw = MD5Utils.md5(psw);
        // 把密码用MD5加密
        // loginInfo表示文件名, mode_private SharedPreferences sp = getSharedPreferences();
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取编辑器， SharedPreferences.Editor editor -> sp.edit();
        SharedPreferences.Editor editor=sp.edit();
        //以用户名为key，密码为value保存在SharedPreferences中
        // key,value,如键值对，editor.putString(用户名，密码）;
        editor.putString(userName, md5Psw);
        //提交修改 editor.commit();
        editor.commit();
    }

}
