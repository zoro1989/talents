package com.ccbjb.service.setting;

import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mybatis.Result;

import java.util.Map;

public interface IDicService {

	Result findPage(Map<String, String> map, Integer pageNo,
                    Integer pageSize);
	void insertSelective(SysDic sysDic);

	Result deleteDicById(Long[] ids);

	Result selectDicParents();

	void deleteByPrimaryKey(Long id);
	Result selectDicById(Long id);

}
