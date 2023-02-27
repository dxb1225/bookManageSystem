package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.ReaderInfoMapper;
import cn.kgc.ssm.pojo.ReaderInfo;
import cn.kgc.ssm.service.ReaderInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {
    @Override
    public void updateReaderInfoSubmit(ReaderInfo readerInfo) {
        readerInfoMapper.updateByPrimaryKey(readerInfo);
    }


    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public ReaderInfo queryUserInfoByNameAndPassword(String username, String password) {
        return readerInfoMapper.queryUserInfoByNameAndPassword(username, password);
    }

    @Override
    public PageInfo<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<ReaderInfo> readerInfoList =  readerInfoMapper.queryAllReaderInfo(readerInfo);
        return new PageInfo<>(readerInfoList);
    }

    @Override
    public PageInfo<ReaderInfo> queryAllReaderInfo2(ReaderInfo readerInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<ReaderInfo> readerInfoList =  readerInfoMapper.queryAllReaderInfo2(readerInfo);
        return new PageInfo<>(readerInfoList);
    }


    @Override
    public ReaderInfo queryReaderInfoById(Integer id) {
        return readerInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addReaderInfoSubmit(ReaderInfo readerInfo) {
      return   readerInfoMapper.insert(readerInfo);
    }


    @Override
    public void deleteReaderInfoByIds(List<String> ids) {
        for (String id : ids){
            readerInfoMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }


}
