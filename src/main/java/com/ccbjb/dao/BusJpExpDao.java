package com.ccbjb.dao;

import com.ccbjb.common.domain.BusJpExp;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface BusJpExpDao extends BaseDao<BusJpExp> {
    List<BusJpExp> findJpExpByStaffId(Long staffId);
    void deleteByStaffId(Long staffId);
}
