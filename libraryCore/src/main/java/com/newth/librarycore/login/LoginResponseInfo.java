package com.newth.librarycore.login;

public class LoginResponseInfo {
    /**
     * @param code:登录成功为 1，失败为 0
     * @param info:code为1返回验证码的值，为0返回失败信息
     */
    private String info;
    private int code;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
