package com.example.loginbegin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginbegin.Activity.BookActivity;
import com.example.loginbegin.Holder.BookHolder;
import com.example.loginbegin.R;
import com.example.loginbegin.model.Book.BookItem;
import com.example.loginbegin.model.Book.BookItemClickListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookHolder> {

    Context c;
    ArrayList<BookItem> books;

    public BookAdapter(Context c, ArrayList<BookItem> books) {
        this.c=c;
        this.books=books;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_book, null);

        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookHolder holder, int position) {
        holder.book_title.setText(books.get(position).getBook_title());
        holder.book_description.setText(books.get(position).getBook_description());
        holder.book_cover.setImageResource(books.get(position).getImg());

        holder.setBookItemClickListener(new BookItemClickListener() {
            @Override
            public void onBookItemClickListener(View v, int position) {
                String book_title = books.get(position).getBook_title();
                String book_description = books.get(position).getBook_description(); //get data from last activity
//                ImageView image = holder.book_cover;
//                Drawable drawable = image.getDrawable();// get image from drawable
//                BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
//
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                ByteArrayOutputStream stream = new ByteArrayOutputStream(); //image will get streams and bytes (?)
//
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream); //compress image
//
//                byte[] bytes = stream.toByteArray();

                //get data with Intent
                Intent intent = new Intent(c, BookActivity.class);
                intent.putExtra("title", book_title);
                intent.putExtra("description", book_description);
//                intent.putExtra("cover", bytes);
                c.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return books.size();
    }
}
