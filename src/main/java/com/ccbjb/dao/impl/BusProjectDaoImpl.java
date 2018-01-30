package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mapper.BusProjectMapper;
import com.ccbjb.common.mapper.BusStaffMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.BusProjectDao;
import com.ccbjb.dao.BusStaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class BusProjectDaoImpl extends AbstractDao<BusProject> implements BusProjectDao {
    @Autowired
    private BusProjectMapper busProjectMapper;

    @Override
    public List<BusProject> findAllProject(Map<String, String> map) {
        return busProjectMapper.findAllProject(map);
    }

    @Override
    public List<BusProject> findProjectItems(Long parentId) {
        return busProjectMapper.findProjectItems(parentId);
    }

}
