package com.newth.librarycore.borrow.bean;

import java.util.List;

public class BorrowBookInfo {
    /**
     * @param borrowInfo :返回值描述
     * @param borrowCount :已借数量
     * @param booklist :已借书籍列表
     */
    private String borrowInfo;
    private int borrowCount;
    private List<BorrowNowBean> booklist;

    public String getBorrowInfo() {
        return borrowInfo;
    }

    public void setBorrowInfo(String borrowInfo) {
        this.borrowInfo = borrowInfo;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public List<BorrowNowBean> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<BorrowNowBean> booklist) {
        this.booklist = booklist;
    }
}
