package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.BusJpExp;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.mapper.BusJpExpMapper;
import com.ccbjb.common.mapper.BusProjectExpMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.BusJpExpDao;
import com.ccbjb.dao.BusProjectExpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class BusJpExpDaoImpl extends AbstractDao<BusJpExp> implements BusJpExpDao {
    @Autowired
    private BusJpExpMapper busJpExpMapper;


    @Override
    public List<BusJpExp> findJpExpByStaffId(Long staffId) {
        return busJpExpMapper.findJpExpByStaffId(staffId);
    }

    @Override
    public void deleteByStaffId(Long staffId) {
        busJpExpMapper.deleteByStaffId(staffId);
    }
}
