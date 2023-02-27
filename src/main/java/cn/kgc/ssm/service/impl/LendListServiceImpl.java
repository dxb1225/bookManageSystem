package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.LendListMapper;
import cn.kgc.ssm.pojo.BookInfo;
import cn.kgc.ssm.pojo.LendList;
import cn.kgc.ssm.service.BookInfoService;
import cn.kgc.ssm.service.LendListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.service.impl
 * @DESCRIPTION:
 * @DATE: 2023/2/22 11:11
 * @Version:1.0
 */
@Service
public class LendListServiceImpl implements LendListService {
    @Autowired
    private LendListMapper lendListMapper;

    @Autowired
    private BookInfoService bookInfoService;

    @Override
    public PageInfo<LendList> queryLendListAll(LendList lendList, int pageNum, int limit) {
        PageHelper.startPage(pageNum,limit);
        List<LendList> lendLists = lendListMapper.queryLendListAll(lendList);
        PageInfo pageInfo =  new PageInfo<>(lendLists);
        return pageInfo;
    }

    @Override
    public int updateLendListById(LendList lendList) {
        lendList.setBackDate(new Date());
        int i = lendListMapper.updateByPrimaryKeySelective(lendList);
        if (lendList.getBackType()==1 || lendList.getBackType()==0){
            BookInfo bookInfo = bookInfoService.findbookInfoById(lendList.getBookId());
            bookInfo.setStatus(0);
            bookInfoService.updatebookInfo(bookInfo);
        }
        return i;
    }

    @Override
    public LendList selectByPrimaryKey(Integer id) {
        return lendListMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LendList> queryLookBookList(Integer rid, Integer bid) {
        return lendListMapper.queryLookBookList(rid, bid);
    }

    @Override
    public int updateLendListByIds(List<String> ids, List<String> bookIds) {
        int i = 0;
        for (String id : ids) {
            LendList lendList = lendListMapper.selectByPrimaryKey(Integer.valueOf(id));
            if (lendList.getBackDate()==null){
                lendList.setBackDate(new Date());
                lendList.setBackType(0);
            }
            i = lendListMapper.updateByPrimaryKeySelective(lendList);
        }
        for (String bookId : bookIds) {
            BookInfo bookInfo = bookInfoService.findbookInfoById(Integer.valueOf(bookId));
            bookInfo.setStatus(0);
            bookInfoService.updatebookInfo(bookInfo);
        }
        return i;
    }

    @Override
    public int deleteLendListById(Integer id, Integer bookId) {
        LendList lendList = lendListMapper.selectByPrimaryKey(id);
        if (lendList.getBackDate() != null){
            BookInfo bookInfo = bookInfoService.findbookInfoById(bookId);
            bookInfo.setStatus(0);
            bookInfoService.updatebookInfo(bookInfo);
            int i =  lendListMapper.deleteLendListById(id);
          return i;
        }
        return 0;
    }

    @Override
    public int deleteLendListByIds(List<String> list, List<String> blist) {
        int i =0;
        for (String id : list) {
            LendList lendList = lendListMapper.selectByPrimaryKey(Integer.valueOf(id));
            if (lendList.getBackDate()!=null){
             i += lendListMapper.deleteLendListById(Integer.valueOf(id));
            }
        }
        for (String bookId : blist) {
            BookInfo bookInfo = bookInfoService.findbookInfoById(Integer.valueOf(bookId));
            bookInfo.setStatus(0);
            bookInfoService.updatebookInfo(bookInfo);
        }
        return i;
    }

    @Override
    public int addLendList(LendList lendList) {
        return lendListMapper.addLendList(lendList);
    }
}
