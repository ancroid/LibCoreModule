package com.newth.librarycore.borrow.bean;

public class BorrowHistoryBean {

    /**
     * @param indexNum: 条码号
     * @param bookname: 书名
     * @param author:   作者
     * @param borrowtime: 借阅日期
     * @param endtime:    归还日期
     * @param bookLocation: 馆藏地
     * @param currentPage: 当前页面
     * @param pageCount: 总页数
     */
    private String indexNum;
    private String bookname;
    private String author;
    private String borrowtime;
    private String endtime;
    private String bookLocation;
    private String currentPage;
    private String pageCount;

    public String getIndexNum() {
        return indexNum;
    }

    public void setIndexNum(String indexNum) {
        this.indexNum = indexNum;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "BorrowHistoryBean{" +
                "indexNum=" + indexNum +
                ", bookname=" + bookname  +
                ", borrowtime=" + borrowtime  +
                ", endtime=" + endtime +
                ", bookLocation="+bookLocation+
                ", currentPage="+currentPage+
                ", pageCount="+pageCount+
                '}';
    }
}
