package com.gxc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 商品es实体类.
 *
 * @author 宫新程
 * @date 2018/9/17 16:20
 */
@Document(indexName = "goods-items-info", type = "goods-items-info")
@Data
public class EsGoodsItemDto {

  /**
   * 添加@id的需要添加构造方法.
   *
   * @param id 主键
   */
  public EsGoodsItemDto(String id) {}

  public EsGoodsItemDto() {}

  /** '主键 . */
  @Id private String id;
  /** '用户memberId . */
  @Field(type = FieldType.Integer)
  private Integer memberId;
  /** '用户memberId . */
  @Field(type = FieldType.Integer)
  private Integer customerId;
  /** '商品id . */
  @Field(type = FieldType.Integer)
  private Integer itemId;
  /** '品牌id . */
  @Field(type = FieldType.Integer)
  private Integer brandId;
  /** '品牌名称 . */
  @Field(type = FieldType.Text, analyzer = "ik_smart")
  private String brandName;
  /** '商品类目id . */
  @Field(type = FieldType.Integer)
  private int cid;
  /** '商品类目名称 . */
  @Field(type = FieldType.Text)
  private String cidName;
  /** '产品组编码 . */
  @Field(type = FieldType.Text)
  private String productGroupCode;
  /** '产品组名称 . */
  @Field(type = FieldType.Text)
  private String productGroupName;
  /** '产业 . */
  @Field(type = FieldType.Text)
  private String industryCode;
  /** '产业名称 . */
  @Field(type = FieldType.Text)
  private String industryName;
  /** '商品单位;计量单位 . */
  @Field(type = FieldType.Text)
  private String itemUnit;
  /** '单品id . */
  @Field(type = FieldType.Integer)
  private Integer itemSkuId;
  /** '编码 . */
  @Field(type = FieldType.Text, analyzer = "ik_smart")
  private String productCode;
  /** '型号 . */
  @Field(type = FieldType.Text, analyzer = "ik_smart")
  private String itemModel;
  /** '易理货上架时间 . */

  /** '商品名称 . */
  @Field(type = FieldType.Text, analyzer = "ik_smart")
  private String itemName;
  /** '卖点 . */
  @Field(type = FieldType.Text, analyzer = "ik_smart")
  private String ad;
  /** '商品主图 . */
  @Field(type = FieldType.Text)
  private String pictureUrl;
  /** '商品的更新时间（价格变化才变） . */
  @Field(type = FieldType.Date)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date itemUpdateTime;
  /** '产业code . */
  @Field(type = FieldType.Text)
  private String cyCode;
  /** '中心code . */
  @Field(type = FieldType.Text)
  private String gmCode;
  /** '修改日期 . */
  @Field(type = FieldType.Text)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;

  @Field(type = FieldType.Text)
  private String attributes;

  @Field(type = FieldType.Integer)
  /** '库存量 . */
  private Integer stockAmount;

  @Field(type = FieldType.Boolean)
  /** '有无库存 . */
  private Boolean inStock;

  @Field(type = FieldType.Boolean)
  /** '订过 . */
  private Boolean ordered;

  @Field(type = FieldType.Double)
  /** '价格. */
  private BigDecimal price;

  @Field(type = FieldType.Integer)
  /** '价格排序字段. */
  private int priceOrder;

  /** '区域Id. */
  @Field(type = FieldType.Text)
  private String areaIds;

  /** '排序码. */
  @Field(type = FieldType.Integer)
  private Integer orderNumber;
}
