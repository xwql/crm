package cn.crm.service.impl;

import cn.crm.bean.BaseDict;
import cn.crm.mapper.BaseDictMapper;
import cn.crm.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息数据字典
 * @author lx
 *
 */

@Service("systemService")
public class SystemServiceImpl implements SystemService{
	
	@Autowired
	private BaseDictMapper baseDictDao;
	//根据类型编号查询数据字典
	public List<BaseDict> findBaseDictListByType(String typecode) {
		return baseDictDao.selectByTypecode(typecode);
	}

}
