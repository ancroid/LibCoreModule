package com.newth.librarycore;

import android.util.Log;

import com.newth.librarycore.bookinfo.bean.BookHoldingInfo;
import com.newth.librarycore.bookinfo.bean.LibBookInfo;
import com.newth.librarycore.borrow.bean.BorrowBookInfo;
import com.newth.librarycore.borrow.bean.BorrowHistoryBean;
import com.newth.librarycore.borrow.bean.BorrowHistoryInfo;
import com.newth.librarycore.borrow.bean.BorrowNowBean;
import com.newth.librarycore.login.LoginResponseInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class JsoupUtil {
    public static LoginResponseInfo parseLoginInfo(String body, String captcha){
        LoginResponseInfo info=new LoginResponseInfo();
        Document document= Jsoup.parse(body);
        String m=document.getElementsByClass("profile-name").text();
        //maybe有更多的验证条件
        if (m!=null&&!m.equals("")){
            Log.d("parseLoginInfo", "login success: "+m);
            info.setCode(1);
            info.setInfo(captcha);
        }else {
            String msg=document.getElementById("fontMsg").text();
            Log.d("parseLoginInfo", "login fail: "+msg);
            info.setCode(0);
            info.setInfo(msg);
        }
        return info;
    }

    public static BorrowBookInfo parseBorrowBookInfo(String body){
        Document document= Jsoup.parse(body);
        BorrowBookInfo bookInfo=new BorrowBookInfo();
        List<BorrowNowBean> list=new ArrayList<>();
        String table=document.getElementsByClass("table_line").text();
        if (table==null||table.equals("")){
            String m=document.getElementsByClass("iconerr").text();
            if (m!=null&&!m.equals("")){
                bookInfo.setBorrowInfo(m);
            }else {
                bookInfo.setBorrowInfo("request false");
            }
        }else {
            Elements tabs=document.getElementsByClass("table_line").select("tr");
            bookInfo.setBorrowCount(tabs.size()-1);
            bookInfo.setBorrowInfo("request success");
            for (int i=1;i<tabs.size();i++){
                Element element=tabs.get(i);
                BorrowNowBean bean=new BorrowNowBean();
                String barCode=element.select("[width=10%]").text();
                String bookname =  element.select("[width=35%]").select("a").text();
                String bookauthor=element.select("[width=35%]").first().ownText().replace("/ ","");
                String bookMarc=element.select("[width=35%]").select("a").attr("href").replace("../opac/item.php?marc_no=","");
                String borrowtime=element.select("[width=13%]").first().text();
                String returntime=element.select("[width=13%]").select("font").text();
                String booklocation=element.select("[width=15%]").text();
                String attachment=element.select("[width=13%]").last().text();
                String renewNum=element.select("[width=6%]").text();

                String checkstring=element.select("[width=5%]").select("input").attr("onclick").replace("'","");
                String temp[]=checkstring.split(",");
                String check=temp[1];

                bean.setBarCode(barCode);
                bean.setBookTitle(bookname);
                bean.setBookAuthor(bookauthor);
                bean.setMarcNo(bookMarc);
                bean.setBorrowTime(borrowtime);
                bean.setEndTime(returntime);
                bean.setBookLocation(booklocation);
                bean.setCheckCode(check);
                bean.setAttachment(attachment);
                bean.setRenewNum(renewNum);

                list.add(bean);
                Log.d("mmmm","parseborrow"+bean.toString());

            }
            bookInfo.setBooklist(list);
        }
        return bookInfo;
    }

    public static LibBookInfo parseBookInfo(String body){
        Document doc = Jsoup.parse(body);
        LibBookInfo libBookInfo=new LibBookInfo();
        List<BookHoldingInfo> holdingInfoList=new ArrayList<>();
        Element ele = doc.getElementById("book_info");
        Elements dl = ele.select("dl.booklist");
        for (Element e : dl) {
            String temp = e.select("dt").first().text();
            //作者和题名
            if (temp.equals("题名/责任者:")) {
                try {
                    if (e.select("dd").text().contains("/")) {
                        String title = e.select("dd > a").text();
                        String author = e.select("dd").text().substring(title.length() + 1);
                        libBookInfo.setAuthor(author);
                        libBookInfo.setBookTitle(title);
                    } else {
                        String title = e.select("dd > a").text();
                        libBookInfo.setBookTitle(title);
                    }
                } catch (Exception ignored) {
                    String title = e.select("dd > a").text();
                    libBookInfo.setBookTitle(title);
                }

            }
            //出版社
            if (temp.equals("出版发行项:")) {
                String publish = e.select("dd").text();
                libBookInfo.setPublish(publish);
            }
            //isbn
            if (temp.equals("ISBN及定价:")) {
                String isbn = e.select("dd").text().replaceAll("/.*", "");
                libBookInfo.setIsbn(isbn);
            }
            if (temp.equals("学科主题:")){
                String theme = e.select("dd").text();
                libBookInfo.setTheme(theme);
            }
            if (temp.equals("提要文摘附注:")){
                String summary=e.select("dd").text();
                libBookInfo.setSummary(summary);
            }
        }

        Log.d("mmmm", "parseBookInfo: "+libBookInfo.toString());
        //馆藏信息
        Elements tables = doc.select("tr.whitetext");
        for (Element e : tables) {
            String indexBookNum = e.select("[width=10%]").first().text();
            String location = e.select("[width=25%]").attr("title");
            String bookStatus = e.select("[width=25%]").last().text();
            String moreUrl = e.select("iframe").attr("src");
            //获取具体位置
//            Document document = Jsoup.connect(moreUrl).get();
//            String body = document.body().ownText();

            BookHoldingInfo holdingInfo = new BookHoldingInfo();
            holdingInfo.setIndexBookNum(indexBookNum);
            holdingInfo.setBookStatus(bookStatus);
            holdingInfo.setBookLocation(location);
            holdingInfo.setBookLocationMore(moreUrl);
            libBookInfo.getHoldingInfos().add(holdingInfo);
            holdingInfoList.add(holdingInfo);
            Log.d("mmmm", "parseBookInfo: "+holdingInfo.toString());
        }
        libBookInfo.setHoldingInfos(holdingInfoList);
        return libBookInfo;
    }


    public static BorrowHistoryInfo praseHistoryBooks(String body){
        List<BorrowHistoryBean> list=new ArrayList<>();
        BorrowHistoryInfo info=new BorrowHistoryInfo();
        Document document= Jsoup.parse(body);
        if (document.getElementsByClass("table_line")==null){
            String m=document.getElementsByClass("iconerr").text();
            if (m!=null&&!m.equals("")){
                info.setInfo(m);
            }else {
                info.setInfo("request fail");
            }
        }else {
            info.setInfo("request success");
            Element ele=document.getElementById("f");
            String currentPage=ele.select("b").select("[color=red]").text();
            String pageCount=ele.select("b").select("[color=black]").text();
            Elements tabs=document.getElementsByClass("table_line").select("tr");
            for (int i=1;i<tabs.size();i++){
                Element element=tabs.get(i);
                String indexnum=element.select("[width=10%]").text();
                String bookname=element.select("[width=25%]").select("a").text();
                String author=element.select("[width=15%]").first().text();
                String borrowtime=element.select("[width=12%]").first().text();
                String endtime=element.select("[width=12%]").last().text();
                String location=element.select("[width=15%]").last().text();
                BorrowHistoryBean bean=new BorrowHistoryBean();
                bean.setAuthor(author);
                bean.setBookLocation(location);
                bean.setBookname(bookname);
                bean.setBorrowtime(borrowtime);
                bean.setEndtime(endtime);
                bean.setIndexNum(indexnum);
                bean.setPageCount(pageCount);
                bean.setCurrentPage(currentPage);
                Log.d("mmm", "praseHistoryBooks: "+bean.toString());
                list.add(bean);
            }
        }
        info.setBooklist(list);
        return info;
    }
}
