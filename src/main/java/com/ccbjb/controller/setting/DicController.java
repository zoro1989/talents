package com.ccbjb.controller.setting;

import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.domain.SysRole;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.project.IProjectService;
import com.ccbjb.service.setting.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户权限管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("dic")
public class DicController extends BaseController{
	
	@Autowired
	IDicService dicService;

	@PostMapping(value="index")
	public Result index(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return dicService.findPage(map,pageNo,pageSize);
	}

	/**
	 * 字典添加
	 * @param dic
	 * @return
	 */
	@PostMapping(value="save")
	public Result save(SysDic dic){
		Result result = null;
		try {
			dicService.insertSelective(dic);
			result = ResultGenerator.genSuccessResult("添加成功");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "添加字典报错。source[%s]",dic.toString());
		}
		return result;
	}
	/**
	 * 删除字典，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @param ids
	 * @return
	 */
	@PostMapping(value="deleteDicById")
	public Result deleteDicById(Long[] ids){
		return dicService.deleteDicById(ids);
	}

	@GetMapping(value="selectDicById")
	public Result selectDicById(Long id){
		return dicService.selectDicById(id);
	}

	@GetMapping(value="selectDicParents")
	public Result selectDicParents(){
		return dicService.selectDicParents();
	}
}
