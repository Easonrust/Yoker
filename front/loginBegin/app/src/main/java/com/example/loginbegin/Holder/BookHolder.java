package com.example.loginbegin.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginbegin.R;
import com.example.loginbegin.model.Book.BookItemClickListener;

public class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView book_cover;
    public TextView book_title, book_description;
    BookItemClickListener bookItemClickListener;

    public BookHolder(@NonNull View itemView) {
        super(itemView);

        this.book_cover=(ImageView)itemView.findViewById(R.id.book_cover);
        this.book_title=(TextView)itemView.findViewById(R.id.book_title);
        this.book_description=(TextView)itemView.findViewById(R.id.book_description);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.bookItemClickListener.onBookItemClickListener(v, getLayoutPosition());
    }

    public void setBookItemClickListener(BookItemClickListener bc) {
        this.bookItemClickListener=bc;

    }
}
