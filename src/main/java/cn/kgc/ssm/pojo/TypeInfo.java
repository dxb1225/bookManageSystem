package cn.kgc.ssm.pojo;

/**
 * @Author:刘安
 * @Package:cn.kgc.ssm.pojo
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:22
 * @Version:1.0
 */
public class TypeInfo {

    private int id;
    private String name;
    private String remarks;

    public TypeInfo() {
    }

    public TypeInfo(int id, String name, String remarks) {
        this.id = id;
        this.name = name;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
