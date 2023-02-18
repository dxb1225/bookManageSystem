package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.Admin;
import com.github.pagehelper.PageInfo;

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
}
