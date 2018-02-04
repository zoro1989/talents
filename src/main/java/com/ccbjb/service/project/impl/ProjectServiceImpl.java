package com.ccbjb.service.project.impl;

import com.ccbjb.common.consts.Const;
import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.BusProjectDao;
import com.ccbjb.dao.BusStaffDao;
import com.ccbjb.dao.SysDicDao;
import com.ccbjb.model.project.BusProjectModel;
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
		List<BusProjectModel> modelList = this.normalizeProjectModel(list);
		PageInfo pageInfo = new PageInfo(list);
		pageInfo.setList(modelList);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	private List<BusProjectModel> normalizeProjectModel(List<BusProject> list) {
		List<BusProjectModel> modelList = new ArrayList<>();
		for (BusProject project : list) {
			BusProjectModel model = new BusProjectModel();
			model.setId(project.getId());
			model.setProjName(project.getProjName());
			model.setStartDate(project.getStartDate());
			model.setEndDate(project.getEndDate());
			if (project.getServiceCustomer()!=null && Const.ServiceCustomerEnum.NRI.getCode() == project.getServiceCustomer()) {
				model.setServiceCustomer(Const.ServiceCustomerEnum.NRI.getValue());
			}else if(project.getServiceCustomer()!=null && Const.ServiceCustomerEnum.MYT.getCode() == project.getServiceCustomer()) {
				model.setServiceCustomer(Const.ServiceCustomerEnum.MYT.getValue());
			}
			model.setContractCount(project.getContractCount());
			model.setPutCount(project.getPutCount());
			List<BusProject> projectItems = project.getProjectItems();
			List<BusProjectModel> modelItemList = new ArrayList<>();
			for (BusProject item : projectItems) {
				BusProjectModel itemModel = new BusProjectModel();
				itemModel.setId(item.getId());
				itemModel.setProjName(item.getProjName());
				itemModel.setStartDate(item.getStartDate());
				itemModel.setEndDate(item.getEndDate());
				if (item.getServiceCustomer()!=null && Const.ServiceCustomerEnum.NRI.getCode() == item.getServiceCustomer()) {
					itemModel.setServiceCustomer(Const.ServiceCustomerEnum.NRI.getValue());
				}else if(item.getServiceCustomer()!=null && Const.ServiceCustomerEnum.MYT.getCode() == item.getServiceCustomer()) {
					itemModel.setServiceCustomer(Const.ServiceCustomerEnum.MYT.getValue());
				}
				itemModel.setContractCount(item.getContractCount());
				itemModel.setPutCount(item.getPutCount());
				modelItemList.add(itemModel);
			}

			model.setProjectItems(modelItemList);
			modelList.add(model);
		}
		return modelList;
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
		return ResultGenerator.genSuccessResult(projectAnalyzeModel);
	}

	@Override
	public Result getChartPieDataByDicType(String type, String dicValue) {
		List<ChartDataModel> res = new ArrayList<>();
		if("0".equals(type)) {
			res = busStaffDao.getChartPersonDataByDicType(dicValue);
		}else if("1".equals(type)) {
			res = busStaffDao.getChartProjectDataByDicType(dicValue);
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
