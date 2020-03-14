package cn.crm.service;

import cn.crm.bean.BaseDict;

import java.util.List;


public interface SystemService {

	//根据类型查询数据字典
	public List<BaseDict> findBaseDictListByType(String typecode);
	
}
