package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.ProductCommentPic;

public interface ProductCommentPicDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCommentPic record);

    Long insertSelective(ProductCommentPic record);

    ProductCommentPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductCommentPic record);

    int updateByPrimaryKey(ProductCommentPic record);
    
    int updateCommentPic(@Param("userId")Long userId, @Param("commentId")Long commentId);
    
    int updateCommentPicByUserId(ProductCommentPic pic);
    
    List<ProductCommentPic> queryListByCommentIdAndUserId(@Param("userId")Long userId,@Param("commentId")Long commentId);
}