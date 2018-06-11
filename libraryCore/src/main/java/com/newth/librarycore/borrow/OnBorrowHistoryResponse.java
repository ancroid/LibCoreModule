package com.newth.librarycore.borrow;

import com.newth.librarycore.borrow.bean.BorrowHistoryInfo;

public interface OnBorrowHistoryResponse {
    void getBorrowHistory(BorrowHistoryInfo historyInfo);
}
