package com.ccbjb.dao;

import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mybatis.BaseDao;
import com.ccbjb.model.permission.SysPermissionModel;
import com.ccbjb.model.project.ChartDataModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface BusStaffDao extends BaseDao<BusStaff> {
    List<BusStaff> findAllStaff(BusStaff busStaff);
    BusStaff selectInfoById(Long id);
    List<ChartDataModel> getPieDataByDicType(String dicType);
}
