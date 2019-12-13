package com.example.loginbegin.model.Book;

public class BookItem {
    private String book_title, book_description;
    private int img;

    public int getImg() {
        return img;
    }

    public String getBook_description() {
        return book_description;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }
}
