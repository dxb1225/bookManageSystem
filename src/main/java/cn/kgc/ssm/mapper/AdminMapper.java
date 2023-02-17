package cn.kgc.ssm.mapper;

import cn.kgc.ssm.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.mapper
 * @DESCRIPTION:
 * @DATE: 2023/2/17 20:42
 * @Version:1.0
 */
public interface AdminMapper {
    Admin queryUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
