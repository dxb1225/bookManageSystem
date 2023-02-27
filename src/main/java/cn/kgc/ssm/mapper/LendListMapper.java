package cn.kgc.ssm.mapper;

import cn.kgc.ssm.pojo.LendList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.mapper
 * @DESCRIPTION:
 * @DATE: 2023/2/20 18:48
 * @Version:1.0
 */
public interface LendListMapper {

    List<LendList> queryLendListAll(LendList lendList);

    int updateByPrimaryKeySelective(LendList lendList);

    LendList selectByPrimaryKey(@Param("id") Integer id);
    List<LendList> queryLookBookList(@Param("rid")Integer rid,@Param("bid")Integer bid);

    int deleteLendListById(@Param("id") Integer id);

    int addLendList(LendList lendList);

    int insertSelective(LendList lendList);
}
