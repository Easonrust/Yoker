package com.example.loginbegin.Fragments;

import androidx.fragment.app.Fragment;

import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
//import com.squareup.okhttp.*;
import okhttp3.*;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginbegin.R;



public class TranslateFragment extends Fragment {

    //okhttp
    private static String subscriptionKey = "a872995b97074a298f4adb299af2f121";
    private static String endpoint = "https://api.cognitive.microsofttranslator.com";
    String url = endpoint + "/translate?api-version=3.0&to=en";

    OkHttpClient client = new OkHttpClient.Builder()
            .protocols(Collections.singletonList(Protocol.HTTP_1_1))
            .build();


    private EditText et_translate;
    private Button btn_text_translate;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_translate, null);

        return view;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //okhttp
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        et_translate=(EditText)view.findViewById(R.id.translateBlock);
        btn_text_translate=(Button)view.findViewById(R.id.btn_text_translate);

        btn_text_translate.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {

                String raw = et_translate.getText().toString().trim();
                Toast.makeText(getActivity(), raw, Toast.LENGTH_LONG).show();

                //Todo：返回的翻译文本魏Response，是一个经过prettify函数转化为字符串的翻译结果
                try {
                    String response = Post(raw);
                    String Response = prettify(response);


                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

    }

    public String Post(String text) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "[{\n\t\"Text\": \""+text+"\"\n}]");
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Content-type", "application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_text_translate:
//                //Todo：将文本temp传给后端，调用后端api得到翻译内容
//                String raw = et_translate.getText().toString().trim();
//                Toast.makeText(getActivity(), raw, Toast.LENGTH_LONG).show();
//                break;
////            case R.id.tv_back:
////                Intent intent=new Intent(TranslateActivity.this, MainActivity.class);
////                startActivity(intent);
//            default:
//                break;
//        }
//    }

    /*
    //返回键,显示的注册，找回密码
    private TextView tv_translate;
    private EditText input;
    private Button translate;


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_translate, null);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input=view.findViewById(R.id.translateBlock);
        translate=view.findViewById(R.id.text_translate);
        tv_translate = view.findViewById(R.id.txt_translate);

        translate.setOnClickListener(this);
        tv_translate.setOnClickListener(this);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.text_translate:
                //Todo：将文本temp传给后端，调用后端api得到翻译内容
                String temp = input.getText().toString();
                Toast.makeText(getActivity(), temp, Toast.LENGTH_LONG).show();
                break;
//            case R.id.tv_back:
//                Intent intent=new Intent(TranslateActivity.this, MainActivity.class);
//                startActivity(intent);
            default:
                break;
        }
    }*/
}
