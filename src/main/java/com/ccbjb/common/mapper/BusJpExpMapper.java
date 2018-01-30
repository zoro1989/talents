package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.BusJpExp;
import com.ccbjb.common.domain.BusProjectExp;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;

public interface BusJpExpMapper extends TKMMapper<BusJpExp> {
    List<BusJpExp> findJpExpByStaffId(Long staffId);
    void deleteByStaffId(Long staffId);
}