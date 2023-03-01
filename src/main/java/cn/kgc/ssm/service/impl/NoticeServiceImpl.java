package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.NoticeMapper;
import cn.kgc.ssm.pojo.Notice;
import cn.kgc.ssm.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public PageInfo<Notice> queryAllNotice(Notice notice, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Notice> noticesList = noticeMapper.queryNoticeAll(notice);
        return new PageInfo<>(noticesList);
    }

    @Override
    public Notice queryNoticeById(Integer id) {
        return noticeMapper.findNotice(id);
    }

    @Override
    public int noticeAdd(Notice notice) {
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public int delNotice(Integer id) {
        return noticeMapper.delNotice(id);
    }

    @Override
    public int delNotices(List<String> ids) {
        return noticeMapper.delNotices(ids);
    }


}
