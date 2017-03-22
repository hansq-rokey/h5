package com.papabear.product.dao;

import com.papabear.product.entity.MallFormatPropertiesValueRelation;

public interface MallFormatPropertiesValueRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallFormatPropertiesValueRelation record);

    int insertSelective(MallFormatPropertiesValueRelation record);

    MallFormatPropertiesValueRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallFormatPropertiesValueRelation record);

    int updateByPrimaryKey(MallFormatPropertiesValueRelation record);
}