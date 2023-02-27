package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.ReaderInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author:连怡
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:52
 * @Version:1.0
 */
public interface ReaderInfoService {
    /**
     * 根据用户名和密码查询用户信息
     */
    ReaderInfo queryUserInfoByNameAndPassword(String username, String password);
    /**
     * 查询所有记录(模糊匹配)
     */
    PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo,Integer pageNum,Integer limit);

    /**
     * 查询所有记录(精准匹配，借书时用)
     */
    PageInfo<ReaderInfo> queryAllReaderInfo2(ReaderInfo readerInfo,Integer pageNum,Integer limit);

    /**
     * 查询（修改前先查询）
     */
    ReaderInfo queryReaderInfoById(Integer id);
    /**
     * 新增
     */
    int addReaderInfoSubmit(ReaderInfo readerInfo);

    /**
     * 修改提交
     */
    void updateReaderInfoSubmit(ReaderInfo readerInfo);

    /**
     * 删除
     */
    void deleteReaderInfoByIds(List<String> ids);



}
