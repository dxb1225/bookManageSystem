package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.TypeInfo;
import com.github.pagehelper.PageInfo;

import java.lang.management.ThreadInfo;
import java.util.List;

/**
 * @Author:刘安
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:23
 * @Version:1.0
 */
public interface TypeInfoService {
    /**
     * 查询所有记录
     */
    /**
     * 查询所有记录
     */
    PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit);


    /**
     * 修改 根据id查询记录信息
     */
    TypeInfo queryTypeInfoById(Integer id);


    /**
     * 添加图书类型
     */

    int addTypeSubmit(TypeInfo info);



    /**
     * 修改提交
     */
    int updateTypeSubmit(TypeInfo info);

    /**
     * 根据ids删除记录信息
     */
    int deleteTypeByIds(List<String> id);

    int deleteTypeById(Integer id);
}
