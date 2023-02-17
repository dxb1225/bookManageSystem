package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.pojo.Admin;
import cn.kgc.ssm.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.service.impl
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:52
 * @Version:1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin queryUserByNameAndPassword(String username, String password) {
        return null;
    }
}
