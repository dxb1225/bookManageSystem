package cn.kgc.ssm.mapper;

import cn.kgc.ssm.pojo.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {
    int insertSelective(BookInfo record);
    int addbookInfo(BookInfo bookInfo);

    int deletebookInfo(int id);

    int updatebookInfo(BookInfo bookInfo);

    List<BookInfo> findAll(BookInfo bookInfo);

    int deletebookInfoByIds(String ids);
    BookInfo findbookInfoById(Integer id);
    List<BookInfo> getBookCountByType();



}
