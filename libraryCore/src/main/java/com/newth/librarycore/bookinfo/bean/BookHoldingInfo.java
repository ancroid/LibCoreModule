package com.newth.librarycore.bookinfo.bean;

public class BookHoldingInfo {

    /**
     * @param indexBookNum:索书号
     * @param bookLocation:馆藏地
     * @param bookStatus:书刊状态
     * @param bookLocationMore:详细位置Url
     */
    private String indexBookNum;
    private String bookLocation;
    private String bookStatus;
    private String bookLocationMore;

    public String getBookLocationMore() {
        return bookLocationMore;
    }

    public void setBookLocationMore(String bookLocationMore) {
        this.bookLocationMore = bookLocationMore;
    }

    public String getIndexBookNum() {
        return indexBookNum;
    }

    public void setIndexBookNum(String indexBookNum) {
        this.indexBookNum = indexBookNum;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "holdingINfo{" +
                "indexBookNum=" + indexBookNum +
                ", bookLocation=" + bookLocation  +
                ", bookLocationMore=" + bookLocationMore  +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
