package com.newth.librarycore.bookinfo.bean;

public class DouBanBookInfo {
    /**
     * @param average:平均分
     * @param smalImge:图书封面小图
     * @param midImge:图书封面中图
     * @param largeImge:图书封面大图
     * @param summary:简介
     */
    private double average;
    private String smalImge;
    private String midImge;
    private String largeImge;
    private String summary;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getSmalImge() {
        return smalImge;
    }

    public void setSmalImge(String smalImge) {
        this.smalImge = smalImge;
    }

    public String getMidImge() {
        return midImge;
    }

    public void setMidImge(String midImge) {
        this.midImge = midImge;
    }

    public String getLargeImge() {
        return largeImge;
    }

    public void setLargeImge(String largeImge) {
        this.largeImge = largeImge;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "BookInfo{ average=" + average +
                ", smalImge='" + smalImge + '\'' +
                ", midImge='" + midImge + '\'' +
                ", largeImge='" + largeImge + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
