package com.ccbjb.service.project;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mybatis.Result;

import java.util.Map;

public interface IProjectService {

	Result findPage(Map<String, String> map, Integer pageNo,
					Integer pageSize);
	void insertSelective(BusProject busProject);

	Result deleteProjectById(Long[] ids);

	Result selectProjectParents();

	void deleteByPrimaryKey(Long id);
	Result selectProjectById(Long id);

	Result selectChartBgData();

	Result getChartPieDataByDicType(String type, String dicValue);

}
