package com.ccbjb.dao;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface BusProjectExpDao extends BaseDao<BusProjectExp> {
    List<BusProjectExp> findProjectExpByStaffId(Long staffId);
    void deleteByStaffId(Long staffId);
}
