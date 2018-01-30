package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;

public interface BusProjectExpMapper extends TKMMapper<BusProjectExp> {
    List<BusProjectExp> findProjectExpByStaffId(Long staffId);
    void deleteByStaffId(Long staffId);
}