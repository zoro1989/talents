package com.ccbjb.service.project.impl;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.BusProjectDao;
import com.ccbjb.dao.BusStaffDao;
import com.ccbjb.dao.SysDicDao;
import com.ccbjb.model.project.ChartDataModel;
import com.ccbjb.model.project.ProjectAnalyzeModel;
import com.ccbjb.service.project.IProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	SysDicDao sysDicDao;
	@Autowired
	BusProjectDao busProjectDao;
	@Autowired
	BusStaffDao busStaffDao;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Result findPage(Map<String, String> map, Integer pageNo,
						   Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<BusProject> list = busProjectDao.findAllProject(map);
		PageInfo pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Override
	@Transactional
	public void insertSelective(BusProject busProject) {
		if(StringUtils.isBlank(busProject.getId())){
			busProjectDao.save(busProject);
		}else{
			busProjectDao.update(busProject);
		}
		List<BusProject> projectItems = busProject.getProjectItems();
		for(BusProject item: projectItems) {
			item.setParentId(busProject.getId());
			if(StringUtils.isBlank(item.getId())){
				busProjectDao.save(item);
			}else{
				busProjectDao.update(item);
			}
		}
	}

	@Transactional
	@Override
	public void deleteByPrimaryKey(Long id) {
		busProjectDao.deleteById(id);
	}

	@Override
	@Transactional
	public Result selectProjectById(Long id) {
		BusProject busProject = busProjectDao.findById(id);

		busProject.setDevLanguageList(sysDicDao.selectDicByDicType("DEV_LANGUAGE"));
		busProject.setOperateSysList(sysDicDao.selectDicByDicType("OPERATE_SYS"));
		busProject.setDevToolList(sysDicDao.selectDicByDicType("DEV_TOOL"));
		busProject.setDevDatabaseList(sysDicDao.selectDicByDicType("DEV_DATABASE"));
		busProject.setDevAppServerList(sysDicDao.selectDicByDicType("DEV_APP_SERVER"));
		busProject.setDevFrameworkList(sysDicDao.selectDicByDicType("DEV_FRAMEWORK"));
		busProject.setServiceCustomerList(sysDicDao.selectDicByDicType("SERVICE_CUSTOMER"));
		busProject.setBusTypeList(sysDicDao.selectDicByDicType("BUS_TYPE"));

		busProject.setProjectItems(busProjectDao.findProjectItems(id));

		return ResultGenerator.genSuccessResult(busProject);
	}

	@Override
	public Result selectChartBgData() {
		ProjectAnalyzeModel projectAnalyzeModel = new ProjectAnalyzeModel();
		projectAnalyzeModel.setPersonalDicList(sysDicDao.findDicParentByType("0"));
		projectAnalyzeModel.setTechDicList(sysDicDao.findDicParentByType("1"));
		projectAnalyzeModel.setProjectDicList(sysDicDao.findDicParentByType("2"));
		return ResultGenerator.genSuccessResult(projectAnalyzeModel);
	}

	@Override
	public Result getChartPieDataByDicType(String type, String dicValue) {
		List<ChartDataModel> res = new ArrayList<>();
		if("0".equals(type)) {
			res = busStaffDao.getPieDataByDicType(dicValue);
		}else if("1".equals(type)) {

		}else if("2".equals(type)) {

		}
		return ResultGenerator.genSuccessResult(res);
	}

	@Override
	@Transactional
	public Result selectProjectParents() {
		BusProject busProject = new BusProject();
		busProject.setDevLanguageList(sysDicDao.selectDicByDicType("DEV_LANGUAGE"));
		busProject.setOperateSysList(sysDicDao.selectDicByDicType("OPERATE_SYS"));
		busProject.setDevToolList(sysDicDao.selectDicByDicType("DEV_TOOL"));
		busProject.setDevDatabaseList(sysDicDao.selectDicByDicType("DEV_DATABASE"));
		busProject.setDevAppServerList(sysDicDao.selectDicByDicType("DEV_APP_SERVER"));
		busProject.setDevFrameworkList(sysDicDao.selectDicByDicType("DEV_FRAMEWORK"));
		busProject.setServiceCustomerList(sysDicDao.selectDicByDicType("SERVICE_CUSTOMER"));
		busProject.setBusTypeList(sysDicDao.selectDicByDicType("BUS_TYPE"));

		return ResultGenerator.genSuccessResult(busProject);
	}

	@Override
	@Transactional
	public Result deleteProjectById(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";

			for (Long id : ids) {
				List<BusProject> items = busProjectDao.findProjectItems(id);
				if(CollectionUtils.isEmpty(items)){
					this.deleteByPrimaryKey(id);
					count++;
				}else {
					return ResultGenerator.genFailResult(ResultCode.ERR_113);
				}
			}
			resultMsg = "成功删除"+count+"个项目！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除项目出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}
}
