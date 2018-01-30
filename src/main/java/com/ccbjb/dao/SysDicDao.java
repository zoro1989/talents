package com.ccbjb.dao;

import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mybatis.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2017/08/01.
 */
public interface SysDicDao extends BaseDao<SysDic> {
    List<SysDic> selectDicByDicType(String dicType);

    List<SysDic> findAllDic(Map<String, String> map);

    List<SysDic> findDicParents();

    List<SysDic> findDicParentByType(String type);
}
