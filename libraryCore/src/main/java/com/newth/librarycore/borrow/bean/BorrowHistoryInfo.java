package com.newth.librarycore.borrow.bean;

import java.util.List;

public class BorrowHistoryInfo {
    /**
     * @param info :信息
     * @param booklist :借阅历史书籍列表
     */
    private String info;
    private List<BorrowHistoryBean> booklist;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<BorrowHistoryBean> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<BorrowHistoryBean> booklist) {
        this.booklist = booklist;
    }
}
