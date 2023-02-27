package cn.kgc.ssm.mapper;

import cn.kgc.ssm.pojo.TypeInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TypeInfoMapper {
    //查询所有的记录信息
    List<TypeInfo> queryTypeInfoAll(@Param(value = "name") String name);



    /**
     * 添加图书类型
     */
     int addTypeSubmit(TypeInfo info);

    /**
     * 修改 根据id查询记录信息，查询弹出修改界，然后修改进行确认提交
     */
    TypeInfo queryTypeInfoById(Integer id);

    /**
     * 修改提交
     */
    int updateTypeSubmit(TypeInfo info);

    /**
     * 根据ids删除记录信息
     */
    int deleteTypeByIds(List<Integer> id);

    int deleteTypeById(Integer id);
}


