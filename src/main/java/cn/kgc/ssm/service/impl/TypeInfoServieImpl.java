package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.mapper.TypeInfoMapper;
import cn.kgc.ssm.pojo.TypeInfo;
import cn.kgc.ssm.service.TypeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeInfoServieImpl implements TypeInfoService {
    @Autowired
    private TypeInfoMapper typeInfoMapper;

    @Override
    public PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<TypeInfo> typeInfoList = typeInfoMapper.queryTypeInfoAll(name);
        return new PageInfo<>(typeInfoList);
    }

    @Override
    public TypeInfo queryTypeInfoById(Integer id) {
        return typeInfoMapper.queryTypeInfoById(id);
    }

    @Override
    public int addTypeSubmit(TypeInfo info) {
        return typeInfoMapper.addTypeSubmit(info);
    }

    @Override
    public int updateTypeSubmit(TypeInfo info) {
         return typeInfoMapper.updateTypeSubmit(info);
    }

    @Override
    public int deleteTypeByIds(List<String> id) {
        List<Integer> list=new ArrayList<>();
        for(String cid:id){
            int id2= Integer.valueOf(cid);
            list.add(id2);
        }
        return typeInfoMapper.deleteTypeByIds(list);
    }

    @Override
    public int deleteTypeById(Integer id) {
        return typeInfoMapper.deleteTypeById(id);
    }


}
