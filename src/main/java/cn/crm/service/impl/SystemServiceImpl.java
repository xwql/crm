package cn.crm.service.impl;

import cn.crm.bean.BaseDict;
import cn.crm.mapper.BaseDictMapper;
import cn.crm.service.SystemService;
import cn.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
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

	public Page<BaseDict> findBaseDictList(Integer page, Integer rows, String type_code, String type_name){
		BaseDict baseDict = new BaseDict();
		baseDict.setStart((page-1)*rows);
		baseDict.setRows(rows);
		if(StringUtils.isNotBlank(type_code))
			baseDict.setType_code(type_code);
		if(StringUtils.isNotBlank(type_name))
			baseDict.setType_name(type_name);
		List<BaseDict> baseDicts = baseDictDao.selectDictList(baseDict);
		Integer count = baseDictDao.selectDictListCount(baseDict);
		Page<BaseDict> result = new Page<>();
		result.setPage(page);
		result.setRows(baseDicts);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	};

	@Override
	public List<BaseDict> findAllTypeName() {
		return baseDictDao.selectAllTypeName();
	}

	@Override
	public BaseDict findBaseDictById(Long id) {
		return baseDictDao.selectByPrimaryKey(id);
	}

	@Override
	public void updateBaseDictById(BaseDict baseDict) {
		baseDictDao.updateBaseDictById(baseDict);
	}

	@Override
	public void saveBaseDict(BaseDict baseDict) {
		baseDictDao.insertBaseDict(baseDict);
	}
}
