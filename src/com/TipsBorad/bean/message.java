package com.TipsBorad.bean;

import java.util.Date;

public class message {

    private long id;
    private long user_id;
    private String username;
    private String title;
    private String content;
    private Date create_time;

    public message( long user_id , String username , String title , String content  ){
//        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.title = title;
        this.content = content;
//        this.create_time = create_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

}
