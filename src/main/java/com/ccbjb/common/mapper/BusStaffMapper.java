package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mybatis.TKMMapper;
import com.ccbjb.model.permission.SysPermissionModel;
import com.ccbjb.model.project.ChartDataModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BusStaffMapper extends TKMMapper<BusStaff> {
    List<BusStaff> findAllStaff(BusStaff busStaff);
    List<ChartDataModel> getPieDataByDicType(@Param("dicType") String dicType);
}