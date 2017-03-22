package com.papabear.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallProduct;

public interface ProductDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallProduct record);

    int insertSelective(MallProduct record);

    MallProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProduct record);
 
    int updateByPrimaryKeyWithBLOBs(MallProduct record);

    int updateByPrimaryKey(MallProduct record);
    
    int updateProductByModelId(@Param("modelId") Long modelId,@Param("title")String title);
    
    /**
     * 根据状态查询产品信息
     * @param status
     * @return
     */
    List<MallProduct> queryProductByStatus(Map map);
    /**
     * 根据状态查询产品信息总数
     * @param status
     * @return
     */
    int queryProductByStatusCount(@Param("status")Byte status);
    
    List<MallProduct> queryProductBySystem(@Param("status")Byte status,@Param("cType")Byte cType,@Param("bType")Byte bType);
    
    /**
     * 根据代理商代理商品的id查询商品列表
     * @param list
     * @param status
     * @param cType
     * @param bType
     * @return
     */
    List<MallProduct> queryProducts(@Param("list")List<Long> list,@Param("status")Byte status,@Param("cType")Byte cType,@Param("bType")Byte bType);
    
    List<MallProduct> queryProductByFormat(Long modelId);
    
    /**
     * 获取产品信息
     * @param id		产品ID
     * @param status	状态
     * @return
     */
    MallProduct getMallProduct(@Param("id")long id,@Param("status")Byte status);
    
    List<MallProduct> selectProductListByIds(List<Long> listProductIds);
    
    /**
     * 根据型号ID查询产品信息，默认查询已上线产品
     * @param id  型号ID
     * @return
     */
    MallProduct getProductByModeleId(Long id);
    
    List<MallProduct> getProductIdAndTitleList();
    
    MallProduct getProductListFormatByPrimaryKey(@Param("id")long id);
    /**
     * 自带分页查询appserver使用
     * @param status
     * @param start
     * @param end
     * @return
     */
    List<MallProduct> selectListMallProduct(@Param("status") Short status, @Param("start") int start, @Param("end") int end);
    /**
     * 根据模板Id查询所有使用该模板的商品信息
     * @param id
     * @return
     */
    List<MallProduct> queryProductByTemplateId(@Param("freightTemplateId")Long id);
}