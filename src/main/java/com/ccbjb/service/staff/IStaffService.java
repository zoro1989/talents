package com.ccbjb.service.staff;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.Result;
import org.springframework.web.multipart.MultipartFile;

public interface IStaffService {
	Result initStaffSearch();

	Result findPage(BusStaff busStaff, Integer pageNo,
					Integer pageSize);
	Result selectInfoById(Long id);

	void insertSelective(BusStaff busStaff);

	Result deleteStaffById(Long[] ids);

	void deleteByPrimaryKey(Long id);

	Result importTalents(MultipartFile file);

}
