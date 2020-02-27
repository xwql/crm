package cn.crm.mapper;

import cn.crm.bean.BaseDict;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BaseDictMapper {

	//根据数据字典类别代码查询
    public List<BaseDict> selectByTypecode(String typecode);
    //根据数据字典ID查询
    BaseDict selectByPrimaryKey(String dictId);

}