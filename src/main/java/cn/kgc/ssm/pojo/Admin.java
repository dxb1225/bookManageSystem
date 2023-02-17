package cn.kgc.ssm.pojo;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.pojo
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:54
 * @Version:1.0
 */
public class Admin {
    private Integer id;
    private String username;
    private String password;

    private Integer adminType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    public Admin(Integer id, String username, String password, Integer adminType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.adminType = adminType;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminType=" + adminType +
                '}';
    }
}
