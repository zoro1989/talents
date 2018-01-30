package com.ccbjb.dao;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface BusProjectDao extends BaseDao<BusProject> {
    List<BusProject> findAllProject(Map<String, String> map);
    List<BusProject> findProjectItems(Long parentId);
}
