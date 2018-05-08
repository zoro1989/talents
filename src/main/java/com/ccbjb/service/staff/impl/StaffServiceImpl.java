package com.ccbjb.service.staff.impl;

import com.ccbjb.common.consts.Const;
import com.ccbjb.common.domain.BusJpExp;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.ExcelUtils;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.*;
import com.ccbjb.model.staff.BusStaffModel;
import com.ccbjb.model.staff.ImportTimeModel;
import com.ccbjb.service.staff.IStaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

	@Override
	public Result initStaffSearch() {
		BusStaff busStaff = new BusStaff();

		busStaff.setSexList(sysDicDao.selectDicByDicType("SEX"));
		busStaff.setJobStatusList(sysDicDao.selectDicByDicType("JOB_STATUS"));
		// busStaff.setYesNoList(sysDicDao.selectDicByDicType("YES_NO"));
		busStaff.setEducationList(sysDicDao.selectDicByDicType("EDUCATION"));
		busStaff.setTrainingModeList(sysDicDao.selectDicByDicType("TRAINING_MODE"));
		busStaff.setDegreeList(sysDicDao.selectDicByDicType("DEGREE"));
		busStaff.setRegisterTypeList(sysDicDao.selectDicByDicType("REGISTER_TYPE"));
		busStaff.setJpLevelList(sysDicDao.selectDicByDicType("JP_LEVEL"));
		busStaff.setEnLevelList(sysDicDao.selectDicByDicType("EN_LEVEL"));
		busStaff.setNationList(sysDicDao.selectDicByDicType("NATION"));
		busStaff.setCountryList(sysDicDao.selectDicByDicType("COUNTRY"));
		busStaff.setIsmarriedList(sysDicDao.selectDicByDicType("IS_MARRIED"));
		busStaff.setHasbabyList(sysDicDao.selectDicByDicType("HAS_BABY"));
		busStaff.setIspartiedList(sysDicDao.selectDicByDicType("IS_PARTIED"));
//		busStaff.setValidList(sysDicDao.selectDicByDicType("VALID"));
		busStaff.setDepartmentList(sysDicDao.selectDicByDicType("DEPARTMENT"));
		busStaff.setDutyList(sysDicDao.selectDicByDicType("DUTY"));
		busStaff.settLevelList(sysDicDao.selectDicByDicType("T_LEVEL"));
		busStaff.setStudentLineList(sysDicDao.selectDicByDicType("STUDENT_LINE"));

		busStaff.setDevLanguageList(sysDicDao.selectDicByDicType("DEV_LANGUAGE"));
		busStaff.setOperateSysList(sysDicDao.selectDicByDicType("OPERATE_SYS"));
		busStaff.setDevToolList(sysDicDao.selectDicByDicType("DEV_TOOL"));
		busStaff.setDevDatabaseList(sysDicDao.selectDicByDicType("DEV_DATABASE"));
		busStaff.setDevAppServerList(sysDicDao.selectDicByDicType("DEV_APP_SERVER"));
		busStaff.setDevFrameworkList(sysDicDao.selectDicByDicType("DEV_FRAMEWORK"));
		busStaff.setServiceCustomerList(sysDicDao.selectDicByDicType("SERVICE_CUSTOMER"));
		busStaff.setBusTypeList(sysDicDao.selectDicByDicType("BUS_TYPE"));

		return ResultGenerator.genSuccessResult(busStaff);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Result findPage(BusStaff busStaff, Integer pageNo,
						   Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<BusStaff> list = busStaffDao.findAllStaff(busStaff);
		List<BusStaffModel> modelList = this.normalizeStaffModel(list);
		PageInfo pageInfo = new PageInfo(list);
		pageInfo.setList(modelList);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	private List<BusStaffModel> normalizeStaffModel(List<BusStaff> list) {
		List<BusStaffModel> modelList = new ArrayList<>();
		for (BusStaff staff: list) {
			BusStaffModel model = new BusStaffModel();
			model.setId(staff.getId());
			model.setStaffNo(staff.getStaffNo());
			model.setName(staff.getName());
			model.setNameKana(staff.getNameKana());
			if (staff.getDuty()!=null && Const.DutyEnum.PG.getCode() == staff.getDuty()) {
				model.setDuty(Const.DutyEnum.PG.getValue());
			}else if(staff.getDuty()!=null && Const.DutyEnum.SE.getCode() == staff.getDuty()) {
				model.setDuty(Const.DutyEnum.SE.getValue());
			}else if(staff.getDuty()!=null && Const.DutyEnum.TL.getCode() == staff.getDuty()){
				model.setDuty(Const.DutyEnum.TL.getValue());
			}else if(staff.getDuty()!=null && Const.DutyEnum.SL.getCode() == staff.getDuty()){
				model.setDuty(Const.DutyEnum.SL.getValue());
			}else if(staff.getDuty()!=null && Const.DutyEnum.PL.getCode() == staff.getDuty()){
				model.setDuty(Const.DutyEnum.PL.getValue());
			}else if(staff.getDuty()!=null && Const.DutyEnum.PM.getCode() == staff.getDuty()){
				model.setDuty(Const.DutyEnum.PM.getValue());
			}

			if(staff.getJpLevel()!=null && Const.JpLevelEnum.N4.getCode() == staff.getJpLevel()) {
				model.setJpLevel(Const.JpLevelEnum.N4.getValue());
			}else if(staff.getJpLevel()!=null && Const.JpLevelEnum.N3.getCode() == staff.getJpLevel()) {
				model.setJpLevel(Const.JpLevelEnum.N3.getValue());
			}else if(staff.getJpLevel()!=null && Const.JpLevelEnum.N2.getCode() == staff.getJpLevel()) {
				model.setJpLevel(Const.JpLevelEnum.N2.getValue());
			}else if(staff.getJpLevel()!=null && Const.JpLevelEnum.N1.getCode() == staff.getJpLevel()) {
				model.setJpLevel(Const.JpLevelEnum.N1.getValue());
			}else {
				model.setJpLevel(Const.JpLevelEnum.OTHER.getValue());
			}
			model.setWorkAge(staff.getWorkAge());
			if(staff.getDepartment()!=null && Const.DepartmentEnum.MYT.getCode() == staff.getDepartment()) {
				model.setDepartment(Const.DepartmentEnum.MYT.getValue());
			}else if(staff.getDepartment()!=null && Const.DepartmentEnum.NRI.getCode() == staff.getDepartment()) {
				model.setDepartment(Const.DepartmentEnum.NRI.getValue());
			}else if(staff.getDepartment()!=null && Const.DepartmentEnum.FINANCE.getCode() == staff.getDepartment()) {
				model.setDepartment(Const.DepartmentEnum.FINANCE.getValue());
			}else if(staff.getDepartment()!=null && Const.DepartmentEnum.ADMIN.getCode() == staff.getDepartment()) {
				model.setDepartment(Const.DepartmentEnum.ADMIN.getValue());
			}else if(staff.getDepartment()!=null && Const.DepartmentEnum.NET.getCode() == staff.getDepartment()) {
				model.setDepartment(Const.DepartmentEnum.NET.getValue());
			}else {
				model.setDepartment(Const.DepartmentEnum.OTHER.getValue());
			}
			modelList.add(model);
		}
		return modelList;
	}
	@Override
	@Transactional
	public Result selectInfoById(Long id) {
		BusStaff busStaff = busStaffDao.selectInfoById(id);

		busStaff.setSexList(sysDicDao.selectDicByDicType("SEX"));
		busStaff.setJobStatusList(sysDicDao.selectDicByDicType("JOB_STATUS"));
		// busStaff.setYesNoList(sysDicDao.selectDicByDicType("YES_NO"));
		busStaff.setEducationList(sysDicDao.selectDicByDicType("EDUCATION"));
		busStaff.setTrainingModeList(sysDicDao.selectDicByDicType("TRAINING_MODE"));
		busStaff.setDegreeList(sysDicDao.selectDicByDicType("DEGREE"));
		busStaff.setRegisterTypeList(sysDicDao.selectDicByDicType("REGISTER_TYPE"));
		busStaff.setJpLevelList(sysDicDao.selectDicByDicType("JP_LEVEL"));
		busStaff.setEnLevelList(sysDicDao.selectDicByDicType("EN_LEVEL"));
		busStaff.setNationList(sysDicDao.selectDicByDicType("NATION"));
		busStaff.setCountryList(sysDicDao.selectDicByDicType("COUNTRY"));
		busStaff.setIsmarriedList(sysDicDao.selectDicByDicType("IS_MARRIED"));
		busStaff.setHasbabyList(sysDicDao.selectDicByDicType("HAS_BABY"));
		busStaff.setIspartiedList(sysDicDao.selectDicByDicType("IS_PARTIED"));
//		busStaff.setValidList(sysDicDao.selectDicByDicType("VALID"));
		busStaff.setDepartmentList(sysDicDao.selectDicByDicType("DEPARTMENT"));
		busStaff.setDutyList(sysDicDao.selectDicByDicType("DUTY"));
		busStaff.settLevelList(sysDicDao.selectDicByDicType("T_LEVEL"));
		busStaff.setStudentLineList(sysDicDao.selectDicByDicType("STUDENT_LINE"));

		busStaff.setDevLanguageList(sysDicDao.selectDicByDicType("DEV_LANGUAGE"));
		busStaff.setOperateSysList(sysDicDao.selectDicByDicType("OPERATE_SYS"));
		busStaff.setDevToolList(sysDicDao.selectDicByDicType("DEV_TOOL"));
		busStaff.setDevDatabaseList(sysDicDao.selectDicByDicType("DEV_DATABASE"));
		busStaff.setDevAppServerList(sysDicDao.selectDicByDicType("DEV_APP_SERVER"));
		busStaff.setDevFrameworkList(sysDicDao.selectDicByDicType("DEV_FRAMEWORK"));
		busStaff.setServiceCustomerList(sysDicDao.selectDicByDicType("SERVICE_CUSTOMER"));
		busStaff.setBusTypeList(sysDicDao.selectDicByDicType("BUS_TYPE"));

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

	@Override
	@Transactional
	public Result importTalents(MultipartFile file) {
		List<BusStaff> busStaffList = ExcelUtils.readFileToVo(file);
		for (BusStaff staff : busStaffList) {
			staff.setCreateTime(new Date());
			busStaffDao.save(staff);
		}
		return ResultGenerator.genSuccessResult("导入完毕");
	}

	@Override
	@Transactional
	public Result findLastImportTime(String type) {
		BusStaff info = busStaffDao.findLastImportInfo();
		ImportTimeModel model = new ImportTimeModel();
		if(StringUtils.isNotBlank(info.getCreateTime())) {
			model.setTalentsImportTime(info.getCreateTime().getTime());
		} else {
			model.setTalentsImportTime(System.currentTimeMillis());
		}
		return ResultGenerator.genSuccessResult(model);
	}

}
