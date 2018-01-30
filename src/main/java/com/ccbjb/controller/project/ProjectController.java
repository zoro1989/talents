package com.ccbjb.controller.project;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.project.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户权限管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("project")
public class ProjectController extends BaseController{
	
	@Autowired
	IProjectService projectService;

	@PostMapping(value="index")
	public Result index(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return projectService.findPage(map,pageNo,pageSize);
	}

	/**
	 * 字典添加
	 * @param busProject
	 * @return
	 */
	@PostMapping(value="save")
	public Result save(@RequestBody BusProject busProject){
		Result result = null;
		try {
			projectService.insertSelective(busProject);
			result = ResultGenerator.genSuccessResult("添加成功");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "添加项目报错。source[%s]",busProject.toString());
		}
		return result;
	}
	/**
	 * 删除字典，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @param ids
	 * @return
	 */
	@PostMapping(value="deleteProjectById")
	public Result deleteProjectById(Long[] ids){
		return projectService.deleteProjectById(ids);
	}

	@GetMapping(value="selectProjectById")
	public Result selectProjectById(Long id){
		return projectService.selectProjectById(id);
	}

	@GetMapping(value="selectProjectParents")
	public Result selectProjectParents(){
		return projectService.selectProjectParents();
	}

	@GetMapping(value="selectChartBgData")
	public Result selectChartBgData(){
		return projectService.selectChartBgData();
	}

	@GetMapping(value = "getChartPieData")
	public Result getChartPieData(String type, String dicValue) {
		return projectService.getChartPieDataByDicType(type, dicValue);
	}

}
