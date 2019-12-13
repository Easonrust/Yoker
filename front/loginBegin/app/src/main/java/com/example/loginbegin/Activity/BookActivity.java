package com.example.loginbegin.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginbegin.R;

public class BookActivity extends AppCompatActivity implements View.OnClickListener{

    public ImageView single_book_cover;
    public TextView single_book_title, single_book_description;

    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout title_bar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ActionBar actionBar = getSupportActionBar();

        single_book_cover=(ImageView)findViewById(R.id.single_book_cover);
        single_book_title=(TextView)findViewById(R.id.single_book_title);
        single_book_description=(TextView)findViewById(R.id.single_book_description);

        //get data from Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");

//        byte[] bytes = getIntent().getByteArrayExtra("cover");
//        //decode image
//        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

//        actionBar.setTitle(title);


        //set data in view
        single_book_title.setText(title);
        single_book_description.setText(description);
//        single_book_cover.setImageBitmap(bitmap);


        tv_back=findViewById(R.id.tv_back);
        tv_main_title=findViewById(R.id.tv_main_title);
        title_bar=findViewById(R.id.title_bar);

        tv_back.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back:
                BookActivity.this.finish();
                break;
            default:
                break;
        }
    }
}
