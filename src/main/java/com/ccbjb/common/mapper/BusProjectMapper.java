package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;
import java.util.Map;

public interface BusProjectMapper extends TKMMapper<BusProject> {
    List<BusProject> findAllProject(Map<String, String> map);
    List<BusProject> findProjectItems(Long parentId);
}