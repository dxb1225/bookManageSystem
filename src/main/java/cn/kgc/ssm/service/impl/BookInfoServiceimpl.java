package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.BookInfoMapper;
import cn.kgc.ssm.pojo.BookInfo;
import cn.kgc.ssm.service.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceimpl implements BookInfoService {
    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public int addbookInfo(BookInfo bookInfo) {
        int i = bookInfoMapper.addbookInfo(bookInfo);
        return i;
    }

    @Override
    public int deletebookInfo(int id) {

        return bookInfoMapper.deletebookInfo(id);
    }

    @Override
    public int updatebookInfo(BookInfo bookInfo) {

        return bookInfoMapper.updatebookInfo(bookInfo);
    }

    @Override
    public PageInfo<BookInfo> findAll(BookInfo bookInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<BookInfo> list = bookInfoMapper.findAll(bookInfo);
        return new PageInfo<>(list);
    }

    @Override
    public int deletebookInfoByIds(String ids) {
        return bookInfoMapper.deletebookInfoByIds(ids);
    }

    @Override
    public BookInfo findbookInfoById(Integer id) {
        return bookInfoMapper.findbookInfoById(id);
    }


}
