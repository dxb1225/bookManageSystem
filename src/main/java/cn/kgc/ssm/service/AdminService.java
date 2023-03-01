package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:51
 * @Version:1.0
 */
public interface AdminService {
    Admin queryUserByNameAndPassword(String username, String password);

    PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum);

    Admin queryAdminById(Integer id);

    List<Integer> findAllAdminType();

    int updateAdminById(Admin admin);

    int addAdmin(Admin admin);

    int deleteAdmin(Integer id);

    int updateAdminPwd(Admin admin);

    int deleteByIds(List<String> ids);
}
