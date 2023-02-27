package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.LendList;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:23
 * @Version:1.0
 */
public interface LendListService {
    /**
     *
     * @param lendList
     * @param pageNum
     * @param limit
     * @return
     */
    PageInfo<LendList> queryLendListAll(LendList lendList, int pageNum, int limit);

    /**
     *
     * @param lendList
     * @return
     */
    int updateLendListById(LendList lendList);

    /**
     *
     * @param id
     * @return
     */
    LendList selectByPrimaryKey(Integer id);

    /**
     *
     * @param rid
     * @param bid
     * @return
     */
    List<LendList> queryLookBookList(Integer rid,Integer bid);

    int updateLendListByIds(List<String> ids, List<String> bookIds);

    int deleteLendListById(Integer id, Integer bookId);

    int deleteLendListByIds(List<String> list, List<String> blist);

    int addLendList(LendList lendList);
}
