package model;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;

/**
 * Created by younghan on 2016. 7. 14..
 */
public class Qna {
    private String title;
    private String name;
    private String password;
    private String content;
    private SimpleDateFormat date;

    public Qna(String title, String name, String password, String content, SimpleDateFormat date) {
        this.title = title;
        this.name = name;
        this.password = password;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }
}
