package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.ReaderInfo;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:52
 * @Version:1.0
 */
public interface ReaderInfoService {
    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);
}
