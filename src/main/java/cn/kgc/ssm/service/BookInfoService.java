package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.BookInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author:赵宇流
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:23
 * @Version:1.0
 */
public interface BookInfoService {
    int addbookInfo(BookInfo bookInfo);

    int deletebookInfo(int id);

    int updatebookInfo(BookInfo bookInfo);
    PageInfo<BookInfo> findAll(BookInfo bookInfo,Integer pageNum,Integer limit);
    int deletebookInfoByIds(String ids);
    BookInfo findbookInfoById(Integer id);



}
