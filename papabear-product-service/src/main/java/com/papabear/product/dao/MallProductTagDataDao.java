package com.papabear.product.dao;

import java.util.List;

import com.papabear.product.entity.MallProductTagData;

public interface MallProductTagDataDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallProductTagData record);

    int insertSelective(MallProductTagData record);

    MallProductTagData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProductTagData record);

    int updateByPrimaryKey(MallProductTagData record);
    
    List<MallProductTagData> queryListTags();
}