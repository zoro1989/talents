package com.ccbjb.controller.staff;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户权限管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("staff")
public class StaffController extends BaseController{
	
	@Autowired
	IStaffService staffService;
	/**
	 * 人才检索初始化
	 * @return
	 */
	@GetMapping(value="index")
	public Result index(){
		return staffService.initStaffSearch();
	}

	@PostMapping(value="search")
	public Result search(BusStaff busStaff, Integer pageNo){
		return staffService.findPage(busStaff,pageNo,pageSize);
	}

	@PostMapping(value = "selectInfoById")
	public Result selectInfoById(Long id){
		return staffService.selectInfoById(id);
	}

	/**
	 * 字典添加
	 * @param busStaff
	 * @return
	 */
	@PostMapping(value="save")
	public Result save(@RequestBody BusStaff busStaff){
		Result result = null;
		try {
			staffService.insertSelective(busStaff);
			result = ResultGenerator.genSuccessResult("添加成功");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "添加员工报错。source[%s]",busStaff.toString());
		}
		return result;
	}
	/**
	 * 删除字典，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @param ids
	 * @return
	 */
	@PostMapping(value="deleteStaffById")
	public Result deleteStaffById(Long[] ids){
		return staffService.deleteStaffById(ids);
	}

}
