package com.ccbjb.common.mapper;

import com.ccbjb.common.domain.BusProject;
import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mybatis.TKMMapper;

import java.util.List;
import java.util.Map;

public interface SysDicMapper extends TKMMapper<SysDic> {
    List<SysDic> selectDicByDicType(String dicType);
    List<SysDic> findAllDic(Map<String, String> map);
    List<SysDic> findDicParents();
    List<SysDic> findDicParentByType(String type);
    List<SysDic> findDicItems(Long parentId);
}