package com.newth.librarycore.borrow;

import com.newth.librarycore.borrow.bean.BorrowBookInfo;

public interface OnBorrowNowResponse {
    void getBorrowInfo(BorrowBookInfo bookInfo);
}
