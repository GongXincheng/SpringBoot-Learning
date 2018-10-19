package com.gxc.controller;

import com.gxc.entity.EsGoodsItemDto;
import javax.annotation.Resource;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * ES的增删改查.
 *
 * @author 宫新程
 * @since 2018/10/19 10:58
 */
@Controller
@Slf4j
public class EsItemController {

  private static final String ES_SEARCH_MEMBER_ID = "memberId";
  private static final String ES_SEARCH_CUSTOMER_ID = "customerId";

  @Resource private ElasticsearchTemplate elasticsearchTemplate;

  /**
   * 查询全部.
   *
   * @return List<EsGoodsItemDto>
   */
  @RequestMapping(value = "/search")
  @ResponseBody
  public List<EsGoodsItemDto> findDoc() {
    // 构造查询条件
    QueryBuilder queryBuilder = QueryBuilders.existsQuery("itemName");
    // 创建分页对象
    Pageable pageable = PageRequest.of(0, 5);
    // 创建 SearchQuery 对象
    SearchQuery searchQuery =
        new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(pageable).build();
    // 设置索引
    searchQuery.addIndices("goods-items-info-9");
    // 设置type
    searchQuery.addTypes("goods-items-info");
    // 查询
    return this.elasticsearchTemplate.queryForList(searchQuery, EsGoodsItemDto.class);
  }

  /**
   * 根据商品id查询商品信息.
   *
   * @param id 商品id
   * @return List<EsGoodsItemDto>
   */
  @RequestMapping("/find/{id}")
  @ResponseBody
  public List<EsGoodsItemDto> findItemById(@PathVariable String id) {
    QueryBuilder queryBuilder = QueryBuilders.termQuery("id", id);
    SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
    // 设置索引
    searchQuery.addIndices("goods-items-info-9");
    // 设置type
    searchQuery.addTypes("goods-items-info");
    return this.elasticsearchTemplate.queryForList(searchQuery, EsGoodsItemDto.class);
  }

  /**
   * 根绝memberId和customerId查询商品信息.
   *
   * @param memberId 理货商Id
   * @param customerId 理货商Id
   */
  @RequestMapping("/find/{memberId}/{customerId}")
  @ResponseBody
  public List<EsGoodsItemDto> deleteByMemberIdAndCustomerId(
      @PathVariable Integer memberId, @PathVariable Integer customerId) {

    // 添加查询条件
    BoolQueryBuilder filter = QueryBuilders.boolQuery();
    QueryBuilder memberIdQuery =
        QueryBuilders.termsQuery(ES_SEARCH_MEMBER_ID, memberId.toString());
    QueryBuilder customerIdQuery =
        QueryBuilders.termsQuery(ES_SEARCH_CUSTOMER_ID, customerId.toString());
    // 匹配 （and ）
    filter.must(memberIdQuery);
    filter.must(customerIdQuery);

    // 删除
    //    DeleteQuery deleteByMemberIdAndCustomerIdQuery = new DeleteQuery();
    //    deleteByMemberIdAndCustomerIdQuery.setQuery(filter);
    //    deleteByMemberIdAndCustomerIdQuery.setIndex("goods-items-info-9");
    //    elasticsearchTemplate.delete(deleteByMemberIdAndCustomerIdQuery,EsGoodsItemDto.class);

    // ES中查询
    SearchQuery searchQuery =
        new NativeSearchQueryBuilder()
            .withFilter(filter)
            .withIndices("goods-items-info-9")
            .withTypes("goods-items-info")
            .build();

    List<EsGoodsItemDto> esGoodsItemDtos =
        this.elasticsearchTemplate.queryForList(searchQuery, EsGoodsItemDto.class);
    System.out.println(esGoodsItemDtos.size());

    return esGoodsItemDtos;
  }
}
