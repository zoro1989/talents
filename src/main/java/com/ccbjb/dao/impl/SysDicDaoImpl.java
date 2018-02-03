package com.ccbjb.dao.impl;

import com.ccbjb.common.domain.SysDic;
import com.ccbjb.common.mapper.SysDicMapper;
import com.ccbjb.common.mybatis.AbstractDao;
import com.ccbjb.dao.SysDicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2017/08/01.
 */
@Component
public class SysDicDaoImpl extends AbstractDao<SysDic> implements SysDicDao {
    @Autowired
    private SysDicMapper sysDicMapper;

    @Override
    public List<SysDic> selectDicByDicType(String dicType) {
        return sysDicMapper.selectDicByDicType(dicType);
    }

    @Override
    public List<SysDic> findAllDic(Map<String, String> map) {
        return sysDicMapper.findAllDic(map);
    }

    @Override
    public List<SysDic> findDicParents() {
        return sysDicMapper.findDicParents();
    }

    @Override
    public List<SysDic> findDicParentByType(String type) {
        return sysDicMapper.findDicParentByType(type);
    }

    @Override
    public List<SysDic> findDicItems(Long parentId) {
        return sysDicMapper.findDicItems(parentId);
    }
}
