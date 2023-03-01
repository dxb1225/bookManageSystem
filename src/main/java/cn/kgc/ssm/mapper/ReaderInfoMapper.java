package cn.kgc.ssm.mapper;



import cn.kgc.ssm.pojo.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ReaderInfoMapper {

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);
    //根据id查询
    ReaderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderInfo record);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(ReaderInfo record);

    //查询所有记录信息(模糊匹配)
    List<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo);
    //查询所有记录信息(精准匹配，借书时用)
    List<ReaderInfo> queryAllReaderInfo2(ReaderInfo readerInfo);
    //根据用户名和密码查询读者信息
    ReaderInfo queryUserInfoByNameAndPassword(@Param("username") String username, @Param("password") String password);


    ReaderInfo findUserByNameAndPassword(@Param("username") String username, @Param("password") String password);

    int updateReaderPwd(ReaderInfo readerInfo);
}
