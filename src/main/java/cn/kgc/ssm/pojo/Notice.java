package cn.kgc.ssm.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Format;
import java.util.Date;

/**
 * @Author:任希建
 * @Package:cn.kgc.ssm.pojo
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:22
 * @Version:1.0
 */
public class Notice{

    private int id;
    private String topic;
    private String content;
    private int author;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private Admin admin;


    public Notice() {
    }

    public Notice(int id, String topic, String content, int author, Date createDate, Admin admin) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.author = author;
        this.createDate = createDate;
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", createDate=" + createDate +
                ", admin=" + admin +
                '}';
    }
}
