package cn.crm.service;

import cn.crm.bean.BaseDict;
import cn.crm.utils.Page;

import java.util.List;


public interface SystemService {

	//根据类型查询数据字典
	public List<BaseDict> findBaseDictListByType(String typecode);
	public Page<BaseDict> findBaseDictList(Integer page, Integer rows, String type_code, String type_name);
	public List<BaseDict> findAllTypeName();
	public BaseDict findBaseDictById(Long id);
	public void updateBaseDictById(BaseDict baseDict);
	public void saveBaseDict(BaseDict baseDict);
}
