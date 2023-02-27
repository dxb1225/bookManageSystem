package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.Notice;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author:任希建
 * @Package:cn.kgc.ssm.service
 * @DESCRIPTION:
 * @DATE: 2023/2/17 11:23
 * @Version:1.0
 */
public interface NoticeService {

      //查询所有公告
      PageInfo<Notice> queryAllNotice(Notice notice,Integer pageNum,Integer limit);

      //查询公告详情
      Notice queryNoticeById(Integer id);

      //新增公告
      int noticeAdd(Notice notice);

      //删除公告
      int delNotice(Integer id);

      //删除多个公告
      int delNotices(List<String> ids);

}
