package cn.kgc.ssm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.pojo
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:21
 * @Version:1.0
 */
public class LendList {
    private Integer id;
    private Integer bookId;
    private Integer readerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lendDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date backDate;

    private Integer backType;
    private String exceptRemarks;

    private BookInfo bookInfo;
    private ReaderInfo readerInfo;

    public LendList(Integer id, Integer bookId, Integer readerId, Date lendDate, Date backDate, Integer backType, String exceptRemarks, BookInfo bookInfo, ReaderInfo readerInfo) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.lendDate = lendDate;
        this.backDate = backDate;
        this.backType = backType;
        this.exceptRemarks = exceptRemarks;
        this.bookInfo = bookInfo;
        this.readerInfo = readerInfo;
    }

    public LendList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
    }

    public String getExceptRemarks() {
        return exceptRemarks;
    }

    public void setExceptRemarks(String exceptRemarks) {
        this.exceptRemarks = exceptRemarks;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public ReaderInfo getReaderInfo() {
        return readerInfo;
    }

    public void setReaderInfo(ReaderInfo readerInfo) {
        this.readerInfo = readerInfo;
    }

    @Override
    public String toString() {
        return "LendList{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", lendDate=" + lendDate +
                ", backDate=" + backDate +
                ", backType=" + backType +
                ", exceptRemarks='" + exceptRemarks  +
                ", bookInfo=" + bookInfo +
                ", readerInfo=" + readerInfo +
                '}';
    }
}
