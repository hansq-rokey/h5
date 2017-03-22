package com.papabear.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallProductPic;

public interface ProductPicDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallProductPic record);

    int insertSelective(MallProductPic record);

    MallProductPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProductPic record);

    int updateByPrimaryKey(MallProductPic record);
    
    List<MallProductPic> queryPics(@Param("productId")Long productId,@Param("formatId") Long formatId, @Param("type")Short type);
    
    /**
     * 查询产品图片
     * @param map
     * @return
     */
    List<MallProductPic> queryProductPicByFormatId(Map<String, Object> map);
}