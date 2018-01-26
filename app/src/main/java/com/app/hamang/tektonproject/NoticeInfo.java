package com.app.hamang.tektonproject;

/**
 * Created by k on 2018-01-25.
 */

public class NoticeInfo {

    String notice;  // 공지사항
    String name;    // 공지사항 이름
    String date;    // 공지사항 날짜

    public NoticeInfo(String name, String date, String notice) {
        this.notice = notice;
        this.name = name;
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
