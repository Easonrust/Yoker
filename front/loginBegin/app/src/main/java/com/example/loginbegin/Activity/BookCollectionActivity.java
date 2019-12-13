package com.example.loginbegin.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginbegin.Adapter.BookAdapter;
import com.example.loginbegin.model.Book.BookItem;
import com.example.loginbegin.R;
import java.util.ArrayList;

public class BookCollectionActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout title_bar;

    RecyclerView book_list;
    BookAdapter bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_collection);

        tv_back=findViewById(R.id.tv_back);
        tv_main_title=findViewById(R.id.tv_main_title);
        title_bar=findViewById(R.id.title_bar);

        book_list=findViewById(R.id.book_list);
        book_list.setLayoutManager(new LinearLayoutManager(this)); // create a recyclerView in a LinearView

        bookAdapter=new BookAdapter(this, getMyList());
        book_list.setAdapter(bookAdapter);

        tv_back.setOnClickListener(this);
    }

    private ArrayList<BookItem> getMyList() {

        ArrayList<BookItem> books = new ArrayList<>();

        //Todo:从后端数据库读取书本信息
        BookItem book = new BookItem();
        book.setBook_title("A");
        book.setBook_description("A book names \'A\'");
        book.setImg(R.drawable.app_icon); //
        books.add(book);

        book = new BookItem();
        book.setBook_title("B");
        book.setBook_description("A book names \'B\'");
        book.setImg(R.drawable.app_icon);
        books.add(book);

        book = new BookItem();
        book.setBook_title("C");
        book.setBook_description("A book names \'C\'");
        book.setImg(R.drawable.app_icon);
        books.add(book);

        book = new BookItem();
        book.setBook_title("D");
        book.setBook_description("A book names \'D\'");
        book.setImg(R.drawable.app_icon);
        books.add(book);


        return books;
    }


    @Override public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back:
                BookCollectionActivity.this.finish();
                break;
            default:
                break;
        }
    }
}
