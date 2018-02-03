package com.ccbjb.service.setting.impl;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.BusProjectDao;
import com.ccbjb.dao.SysDicDao;
import com.ccbjb.service.project.IProjectService;
import com.ccbjb.service.setting.IDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DicServiceImpl implements IDicService {
	@Autowired
	SysDicDao sysDicDao;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Result findPage(Map<String, String> map, Integer pageNo,
						   Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<SysDic> list = sysDicDao.findAllDic(map);
		PageInfo pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Override
	@Transactional
	public void insertSelective(SysDic sysDic) {
		if(StringUtils.isBlank(sysDic.getId())){
			sysDicDao.save(sysDic);
		}else{
			sysDicDao.update(sysDic);
		}
	}

	@Transactional
	@Override
	public void deleteByPrimaryKey(Long id) {
		sysDicDao.deleteById(id);
	}

	@Override
	@Transactional
	public Result selectDicById(Long id) {
		SysDic sysDic = sysDicDao.findById(id);

		sysDic.setDicParents(sysDicDao.findDicParents());

		return ResultGenerator.genSuccessResult(sysDic);
	}

	@Override
	public Result selectDicParents() {
		return ResultGenerator.genSuccessResult(sysDicDao.findDicParents());
	}

	@Override
	@Transactional
	public Result deleteDicById(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";

			for (Long id : ids) {
				List<SysDic> dicItems = sysDicDao.findDicItems(id);
				if(CollectionUtils.isEmpty(dicItems)){
					this.deleteByPrimaryKey(id);
					count++;
				}else {
					return ResultGenerator.genFailResult(ResultCode.ERR_113);
				}
			}
			resultMsg = "成功删除"+count+"个字典！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除字典出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

}
