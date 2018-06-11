package com.newth.librarycore.borrow.bean;

public class BorrowNowBean {
    /**
     * @param barCode :条形码
     * @param bookTitle :标题
     * @param bookAuthor :作者
     * @param renewNum :续借量
     * @param bookLocation :馆藏地
     * @param borrowTime :借阅时间
     * @param endTime :归还时间
     * @param marcNo :详情marc值
     * @param attachment :附件
     * @param checkCode :续借关键字
     */
    private String barCode;
    private String bookTitle;
    private String bookAuthor;
    private String renewNum;
    private String bookLocation;
    private String borrowTime;
    private String endTime;
    private String marcNo;
    private String attachment;
    private String checkCode;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getRenewNum() {
        return renewNum;
    }

    public void setRenewNum(String renewNum) {
        this.renewNum = renewNum;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String brrowTime) {
        this.borrowTime = brrowTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMarcNo() {
        return marcNo;
    }

    public void setMarcNo(String marcNo) {
        this.marcNo = marcNo;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "BorrowNowBean{" +
                "barCode=" + barCode +
                ", bookTitle=" + bookTitle  +
                ", bookAuthor=" + bookAuthor  +
                ", renewNum=" + renewNum +
                ", bookLocation="+bookLocation+
                ", borrowTime="+borrowTime+
                ", endTime="+endTime+
                ", marcNo="+marcNo+
                ", attachment="+attachment+
                ", checkCode="+checkCode+
                '}';
    }
}
