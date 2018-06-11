package com.newth.libcoremoudle.debug;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.newth.libcoremoudle.R;
import com.newth.librarycore.bookinfo.BookInfoUtil;
import com.newth.librarycore.bookinfo.OnBookInfoResponse;
import com.newth.librarycore.bookinfo.bean.LibBookInfo;
import com.newth.librarycore.borrow.BorrowUtil;
import com.newth.librarycore.borrow.OnBorrowHistoryResponse;
import com.newth.librarycore.borrow.OnBorrowNowResponse;
import com.newth.librarycore.borrow.OnReNewBookResponse;
import com.newth.librarycore.borrow.bean.BorrowBookInfo;
import com.newth.librarycore.borrow.bean.BorrowHistoryInfo;
import com.newth.librarycore.login.LoginLibUtil;
import com.newth.librarycore.login.LoginResponseInfo;
import com.newth.librarycore.login.OnCaptchaResponse;
import com.newth.librarycore.login.OnCookieResponse;
import com.newth.librarycore.login.OnLoginResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);
        Button button5=findViewById(R.id.button5);
        Button button6=findViewById(R.id.button6);
        Button button7=findViewById(R.id.button7);
        final EditText edit1=findViewById(R.id.edit1);
        final ImageView image=findViewById(R.id.image1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginLibUtil.getCookie(new OnCookieResponse() {
                    @Override
                    public void getCookie(String cookie) {
                        Log.d("main", "getCookie: "+cookie);
                        Util.writeCookieToSP(cookie);
                    }
                });
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginLibUtil.getCaptcha(Util.readCookieFromSP(),new OnCaptchaResponse() {
                    @Override
                    public void getCaptcha(Bitmap bitmap) {
                        image.setImageBitmap(bitmap);
                    }
                });

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mm=edit1.getText().toString();
                Log.d("activity", "onClick: "+mm);
                LoginLibUtil.LoginToLib(Util.readCookieFromSP(),"201521092113", "159951", mm, new OnLoginResponse() {
                    @Override
                    public void getResponse(LoginResponseInfo info) {
                        Log.d("main", "getResponse: "+info.getCode());
                        Util.writeCaptchaToSP(mm);
                    }
                });
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BorrowUtil.getBorrowBook(Util.readCookieFromSP(), new OnBorrowNowResponse() {
                    @Override
                    public void getBorrowInfo(BorrowBookInfo bookInfo) {
                        Log.d("main", "getBorrowInfo: "+bookInfo.getBorrowCount()+" "+bookInfo.getBorrowInfo());
                    }
                });
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m2= Util.readCaptchaFromSP();
                Log.d("main", "input captcha: "+m2);
                BorrowUtil.reNewBook(Util.readCookieFromSP(), "2006176", "3C3FA9D7", m2, new OnReNewBookResponse() {
                    @Override
                    public void getRenewInfo(String info) {
                        Log.d("main", "getRenewInfo: "+info);
                    }
                });
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookInfoUtil.getBookInfoFromLib("2f4b4c73595267426746556b795a486f782f575176413d3d", new OnBookInfoResponse() {
                    @Override
                    public void getResponse(LibBookInfo bookInfo) {
                        Log.d("main", "getResponse: "+bookInfo.toString());
                    }
                });
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BorrowUtil.getBorrowHistory(Util.readCookieFromSP(), "1", new OnBorrowHistoryResponse() {
                    @Override
                    public void getBorrowHistory(BorrowHistoryInfo historyInfo) {
                        Log.d("main", "getBorrowHistory: "+historyInfo.getInfo());
                    }
                });
            }
        });
    }
}
