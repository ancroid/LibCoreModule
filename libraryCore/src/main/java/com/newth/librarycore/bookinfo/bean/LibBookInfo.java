package com.newth.librarycore.bookinfo.bean;

import java.util.ArrayList;
import java.util.List;

public class LibBookInfo {
    /**
     * @param bookTitle:书名
     * @param author:作者
     * @param publish:出版社
     * @param isbn:isbn
     * @param theme:学科主题
     * @param summary:图书简介（来源豆瓣）
     * @param holdingInfos:馆藏详细信息
     */
    private String bookTitle;
    private String author;
    private String publish;
    private String isbn;
    private String theme;
    private String summary;
    private List<BookHoldingInfo> holdingInfos = new ArrayList<>();

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<BookHoldingInfo> getHoldingInfos() {
        return holdingInfos;
    }

    public void setHoldingInfos(List<BookHoldingInfo> holdingInfos) {
        this.holdingInfos = holdingInfos;
    }
    @Override
    public String toString() {
        return "BookInfo{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", holdingInfos=" + holdingInfos +
                ", summary='" + summary + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
