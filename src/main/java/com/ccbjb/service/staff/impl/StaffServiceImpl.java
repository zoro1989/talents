package com.ccbjb.service.staff.impl;

import com.ccbjb.common.domain.BusJpExp;
import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.*;
import com.ccbjb.service.staff.IStaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {
	@Autowired
	SysDicDao sysDicDao;
	@Autowired
	BusStaffDao busStaffDao;
	@Autowired
	BusProjectDao busProjectDao;
	@Autowired
	BusProjectExpDao busProjectExpDao;
	@Autowired
	BusJpExpDao busJpExpDao;
	public Result initStaffSearch() {
		BusStaff busStaff = new BusStaff();

		busStaff.setSexList(sysDicDao.selectDicByDicType("SEX"));
		busStaff.setYesNoList(sysDicDao.selectDicByDicType("YES_NO"));
		busStaff.setEducationList(sysDicDao.selectDicByDicType("EDUCATION"));
		busStaff.setTrainingModeList(sysDicDao.selectDicByDicType("TRAINING_MODE"));
		busStaff.setDegreeList(sysDicDao.selectDicByDicType("DEGREE"));
		busStaff.setRegisterTypeList(sysDicDao.selectDicByDicType("REGISTER_TYPE"));
		busStaff.setJpLevelList(sysDicDao.selectDicByDicType("JP_LEVEL"));
		busStaff.setEnLevelList(sysDicDao.selectDicByDicType("EN_LEVEL"));
		busStaff.setNationList(sysDicDao.selectDicByDicType("NATION"));
		busStaff.setCountryList(sysDicDao.selectDicByDicType("COUNTRY"));
		busStaff.setValidList(sysDicDao.selectDicByDicType("VALID"));
		busStaff.setDepartmentList(sysDicDao.selectDicByDicType("DEPARTMENT"));
		busStaff.setDutyList(sysDicDao.selectDicByDicType("DUTY"));

		return ResultGenerator.genSuccessResult(busStaff);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Result findPage(BusStaff busStaff, Integer pageNo,
						   Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<BusStaff> list = busStaffDao.findAllStaff(busStaff);
		PageInfo pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Override
	@Transactional
	public Result selectInfoById(Long id) {
		BusStaff busStaff = busStaffDao.selectInfoById(id);

		busStaff.setSexList(sysDicDao.selectDicByDicType("SEX"));
		busStaff.setYesNoList(sysDicDao.selectDicByDicType("YES_NO"));
		busStaff.setEducationList(sysDicDao.selectDicByDicType("EDUCATION"));
		busStaff.setTrainingModeList(sysDicDao.selectDicByDicType("TRAINING_MODE"));
		busStaff.setDegreeList(sysDicDao.selectDicByDicType("DEGREE"));
		busStaff.setRegisterTypeList(sysDicDao.selectDicByDicType("REGISTER_TYPE"));
		busStaff.setJpLevelList(sysDicDao.selectDicByDicType("JP_LEVEL"));
		busStaff.setEnLevelList(sysDicDao.selectDicByDicType("EN_LEVEL"));
		busStaff.setNationList(sysDicDao.selectDicByDicType("NATION"));
		busStaff.setCountryList(sysDicDao.selectDicByDicType("COUNTRY"));
		busStaff.setValidList(sysDicDao.selectDicByDicType("VALID"));
		busStaff.setDepartmentList(sysDicDao.selectDicByDicType("DEPARTMENT"));
		busStaff.setDutyList(sysDicDao.selectDicByDicType("DUTY"));

		busStaff.setBusProjectList(busProjectDao.findAll());
		busStaff.setBusProjectExpList(busProjectExpDao.findProjectExpByStaffId(id));
		busStaff.setBusJpExpList(busJpExpDao.findJpExpByStaffId(id));
		return ResultGenerator.genSuccessResult(busStaff);
	}

	@Override
	@Transactional
	public void insertSelective(BusStaff busStaff) {
		if(StringUtils.isBlank(busStaff.getId())){
			busStaffDao.save(busStaff);
		}else{
			busStaffDao.update(busStaff);
		}
		List<BusProjectExp> busProjectExpList = busStaff.getBusProjectExpList();
		List<BusJpExp> busJpExpList = busStaff.getBusJpExpList();
		for(BusProjectExp busProjectExp: busProjectExpList) {
			busProjectExp.setStaffId(busStaff.getId());
			if(StringUtils.isBlank(busProjectExp.getId())){
				busProjectExpDao.save(busProjectExp);
			}else{
				busProjectExpDao.update(busProjectExp);
			}
		}
		for(BusJpExp busJpExp : busJpExpList) {
			busJpExp.setStaffId(busStaff.getId());
			if(StringUtils.isBlank(busJpExp.getId())){
				busJpExpDao.save(busJpExp);
			}else{
				busJpExpDao.update(busJpExp);
			}
		}
	}

	@Override
	@Transactional
	public Result deleteStaffById(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";

			for (Long id : ids) {
				this.deleteByPrimaryKey(id);
				count++;
			}
			resultMsg = "成功删除"+count+"个员工！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除员工出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@Override
	@Transactional
	public void deleteByPrimaryKey(Long id) {
		busStaffDao.deleteById(id);
		busProjectExpDao.deleteByStaffId(id);
		busJpExpDao.deleteByStaffId(id);
	}

}
