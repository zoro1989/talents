package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.mapper.BusProjectExpMapper;
import com.ccbjb.common.mapper.BusProjectMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.BusProjectDao;
import com.ccbjb.dao.BusProjectExpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class BusProjectExpDaoImpl extends AbstractDao<BusProjectExp> implements BusProjectExpDao {
    @Autowired
    private BusProjectExpMapper busProjectExpMapper;


    @Override
    public List<BusProjectExp> findProjectExpByStaffId(Long staffId) {
        return busProjectExpMapper.findProjectExpByStaffId(staffId);
    }

    @Override
    public void deleteByStaffId(Long staffId) {
        busProjectExpMapper.deleteByStaffId(staffId);
    }
}
