package com.fengmi.goods.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huanglian
 * @since 2022-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MallGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "spu_id", type = IdType.AUTO)
    private Long spuId;

    /**
     * 货号
     */
    private String productSn;

    /**
     * SPU名
     */
    private String goodsName;

    /**
     * 默认SKU
     */
    private Long defaultSkuId;

    /**
     * 状态 0：未审核 1：审核通过 2：审核不通过
     */
    private String auditStatus;

    /**
     * 是否上架 0：下架 1：上架
     */
    private String isMarketable;

    /**
     * 品牌
     */
    private Long brandId;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 一级类目
     */
    private Long category1Id;

    /**
     * 二级类目
     */
    private Long category2Id;

    /**
     * 三级类目
     */
    private Long category3Id;

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    private String albumPics;

    /**
     * 商城价
     */
    private BigDecimal price;

    /**
     * 分类模板ID
     */
    private Long typeTemplateId;

    /**
     * 是否启用规格
     */
    private String isEnableSpec;

    /**
     * 是否删除 0:表示不删除  1：表示删除
     */
    private String isDelete;

    /**
     * 文案id（作废）
     */
    private String copyId;

    /**
     * 商品的规格信息
     */
    private String spuSpecInfo;

    /**
     * 热度值  =销量*0.6+好评*0.2+浏览量*0.1+物流速度*0.1
     */
    private Integer hot;

    /**
     * 销量
     */
    private Integer sale;

    private Date createTime;

    private Date updateTime;

    /**
     * 商家ID  作废
     */
    private String userId;


}
