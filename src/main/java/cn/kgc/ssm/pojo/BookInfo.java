package cn.kgc.ssm.pojo;

import java.sql.Date;

/**
 * @Author:赵宇流
 * @Package:cn.kgc.ssm.pojo
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:22
 * @Version:1.0
 */
public class BookInfo {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private String isbn;
    private String introduction;
    private String language;
    private double price;

    private Date publishDate;

    private Integer typeId;
    private TypeInfo typeInfo;
    private Integer status;

    private Integer counts;

    public BookInfo(Integer id, String name, String author, String publish, String isbn, String introduction, String language, double price, Date publishDate, Integer typeId, TypeInfo typeInfo, Integer status, Integer counts) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.isbn = isbn;
        this.introduction = introduction;
        this.language = language;
        this.price = price;
        this.publishDate = publishDate;
        this.typeId = typeId;
        this.typeInfo = typeInfo;
        this.status = status;
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", isbn='" + isbn + '\'' +
                ", introduction='" + introduction + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", typeId=" + typeId +
                ", typeInfo=" + typeInfo +
                ", status=" + status +
                ", counts=" + counts +
                '}';
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public BookInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public TypeInfo getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(TypeInfo typeInfo) {
        this.typeInfo = typeInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
