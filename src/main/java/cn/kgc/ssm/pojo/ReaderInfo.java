package cn.kgc.ssm.pojo;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author:连怡
 * @Package:cn.kgc.ssm.pojo
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:56
 * @Version:1.0
 */
public class    ReaderInfo {
    private int id;
    private String username;
    private String password;
    private String realName;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date birthday;
    private String address;
    private String tel;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;

    private String readerNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getReaderNumber() {
        return readerNumber;
    }

    public void setReaderNumber(String readerNumber) {
        this.readerNumber = readerNumber;
    }

    @Override
    public String toString() {
        return "ReaderInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", readerNumber='" + readerNumber + '\'' +
                '}';
    }

    public ReaderInfo(int id, String username, String password, String realName, String sex, java.sql.Date birthday, String address, String tel, String email, Date registerDate, String readerNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.registerDate = registerDate;
        this.readerNumber = readerNumber;
    }

    public ReaderInfo() {
    }
}
