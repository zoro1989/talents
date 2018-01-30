package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.domain.SysPermission;
import com.ccbjb.common.mapper.BusStaffMapper;
import com.ccbjb.common.mapper.SysPermissionMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.BusStaffDao;
import com.ccbjb.dao.SysPermissionDao;
import com.ccbjb.model.permission.SysPermissionModel;
import com.ccbjb.model.project.ChartDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class BusStaffDaoImpl extends AbstractDao<BusStaff> implements BusStaffDao {
    @Autowired
    private BusStaffMapper busStaffMapper;

    @Override
    public List<BusStaff> findAllStaff(BusStaff busStaff) {
        return busStaffMapper.findAllStaff(busStaff);
    }

    @Override
    public BusStaff selectInfoById(Long id) {
        return busStaffMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ChartDataModel> getPieDataByDicType(String dicType) {
        return busStaffMapper.getPieDataByDicType(dicType);
    }


}
