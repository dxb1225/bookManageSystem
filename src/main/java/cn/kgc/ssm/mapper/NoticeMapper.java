package cn.kgc.ssm.mapper;

import cn.kgc.ssm.pojo.Notice;

import java.util.List;

public interface NoticeMapper {

    //查询所有公告
    List<Notice> queryNoticeAll(Notice notice);


    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    //删除公告
    int delNotice(Integer id);

    //删除多个公告
    int delNotices(List<String> ids);

    Notice findNotice(Integer id);

}
