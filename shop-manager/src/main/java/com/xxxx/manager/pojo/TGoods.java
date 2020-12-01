package com.xxxx.manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;

@TableName(value = "t_goods")
public class TGoods {

    /**
     * 分页查询
     */
    @TableField(exist = false)
    private Integer  pageSize;
    @TableField(exist = false)
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Boolean getFreeShipping() {
        return isFreeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        isFreeShipping = freeShipping;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    /**
     * 商品id
     */
    @TableId(value = "goods_id", type = IdType.INPUT)
    private Integer goodsId;

    /**
     * 分类id
     */
    @TableField(value = "cat_id")
    private Integer catId;

    /**
     * 扩展分类id
     */
    @TableField(value = "extend_cat_id")
    private Integer extendCatId;

    /**
     * 商品编号
     */
    @TableField(value = "goods_sn")
    private String goodsSn;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 点击数
     */
    @TableField(value = "click_count")
    private Integer clickCount;

    /**
     * 品牌id
     */
    @TableField(value = "brand_id")
    private Short brandId;

    /**
     * 库存数量
     */
    @TableField(value = "store_count")
    private Short storeCount;

    /**
     * 商品评论数
     */
    @TableField(value = "comment_count")
    private Short commentCount;

    /**
     * 商品重量克为单位
     */
    @TableField(value = "weight")
    private Integer weight;

    /**
     * 市场价
     */
    @TableField(value = "market_price")
    private BigDecimal marketPrice;

    /**
     * 本店价
     */
    @TableField(value = "shop_price")
    private BigDecimal shopPrice;

    /**
     * 商品成本价
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 商品关键词
     */
    @TableField(value = "keywords")
    private String keywords;

    /**
     * 商品简单描述
     */
    @TableField(value = "goods_remark")
    private String goodsRemark;

    /**
     * 商品详细描述
     */
    @TableField(value = "goods_content")
    private String goodsContent;

    /**
     * 商品上传原始图
     */
    @TableField(value = "original_img")
    private String originalImg;

    /**
     * 是否为实物
     */
    @TableField(value = "is_real")
    private Byte isReal;

    /**
     * 是否上架
     */
    @TableField(value = "is_on_sale")
    private Byte isOnSale;

    /**
     * 是否包邮0否1是
     */
    @TableField(value = "is_free_shipping")
    private Boolean isFreeShipping;

    /**
     * 商品上架时间
     */
    @TableField(value = "on_time")
    private Integer onTime;

    /**
     * 商品排序
     */
    @TableField(value = "sort")
    private Short sort;

    /**
     * 是否推荐
     */
    @TableField(value = "is_recommend")
    private Byte isRecommend;

    /**
     * 是否新品
     */
    @TableField(value = "is_new")
    private Boolean isNew;

    /**
     * 是否热卖
     */
    @TableField(value = "is_hot")
    private Byte isHot;

    /**
     * 最后更新时间
     */
    @TableField(value = "last_update")
    private Integer lastUpdate;

    /**
     * 商品所属类型id，取值表goods_type的cat_id
     */
    @TableField(value = "goods_type")
    private Short goodsType;

    /**
     * 商品规格类型，取值表goods_type的cat_id
     */
    @TableField(value = "spec_type")
    private Short specType;

    /**
     * 购买商品赠送积分
     */
    @TableField(value = "give_integral")
    private Integer giveIntegral;

    /**
     * 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    @TableField(value = "exchange_integral")
    private Integer exchangeIntegral;

    /**
     * 供货商ID
     */
    @TableField(value = "suppliers_id")
    private Short suppliersId;

    /**
     * 商品销量
     */
    @TableField(value = "sales_sum")
    private Integer salesSum;

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    @TableField(value = "prom_type")
    private Boolean promType;

    /**
     * 优惠活动id
     */
    @TableField(value = "prom_id")
    private Integer promId;

    /**
     * 佣金用于分销分成
     */
    @TableField(value = "commission")
    private BigDecimal commission;

    /**
     * SPU
     */
    @TableField(value = "spu")
    private String spu;

    /**
     * SKU
     */
    @TableField(value = "sku")
    private String sku;

    public static final String COL_GOODS_ID = "goods_id";

    public static final String COL_CAT_ID = "cat_id";

    public static final String COL_EXTEND_CAT_ID = "extend_cat_id";

    public static final String COL_GOODS_SN = "goods_sn";

    public static final String COL_GOODS_NAME = "goods_name";

    public static final String COL_CLICK_COUNT = "click_count";

    public static final String COL_BRAND_ID = "brand_id";

    public static final String COL_STORE_COUNT = "store_count";

    public static final String COL_COMMENT_COUNT = "comment_count";

    public static final String COL_WEIGHT = "weight";

    public static final String COL_MARKET_PRICE = "market_price";

    public static final String COL_SHOP_PRICE = "shop_price";

    public static final String COL_COST_PRICE = "cost_price";

    public static final String COL_KEYWORDS = "keywords";

    public static final String COL_GOODS_REMARK = "goods_remark";

    public static final String COL_GOODS_CONTENT = "goods_content";

    public static final String COL_ORIGINAL_IMG = "original_img";

    public static final String COL_IS_REAL = "is_real";

    public static final String COL_IS_ON_SALE = "is_on_sale";

    public static final String COL_IS_FREE_SHIPPING = "is_free_shipping";

    public static final String COL_ON_TIME = "on_time";

    public static final String COL_SORT = "sort";

    public static final String COL_IS_RECOMMEND = "is_recommend";

    public static final String COL_IS_NEW = "is_new";

    public static final String COL_IS_HOT = "is_hot";

    public static final String COL_LAST_UPDATE = "last_update";

    public static final String COL_GOODS_TYPE = "goods_type";

    public static final String COL_SPEC_TYPE = "spec_type";

    public static final String COL_GIVE_INTEGRAL = "give_integral";

    public static final String COL_EXCHANGE_INTEGRAL = "exchange_integral";

    public static final String COL_SUPPLIERS_ID = "suppliers_id";

    public static final String COL_SALES_SUM = "sales_sum";

    public static final String COL_PROM_TYPE = "prom_type";

    public static final String COL_PROM_ID = "prom_id";

    public static final String COL_COMMISSION = "commission";

    public static final String COL_SPU = "spu";

    public static final String COL_SKU = "sku";

    /**
     * 获取商品id
     *
     * @return goods_id - 商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品id
     *
     * @param goodsId 商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取分类id
     *
     * @return cat_id - 分类id
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * 设置分类id
     *
     * @param catId 分类id
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * 获取扩展分类id
     *
     * @return extend_cat_id - 扩展分类id
     */
    public Integer getExtendCatId() {
        return extendCatId;
    }

    /**
     * 设置扩展分类id
     *
     * @param extendCatId 扩展分类id
     */
    public void setExtendCatId(Integer extendCatId) {
        this.extendCatId = extendCatId;
    }

    /**
     * 获取商品编号
     *
     * @return goods_sn - 商品编号
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * 设置商品编号
     *
     * @param goodsSn 商品编号
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取点击数
     *
     * @return click_count - 点击数
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 设置点击数
     *
     * @param clickCount 点击数
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 获取品牌id
     *
     * @return brand_id - 品牌id
     */
    public Short getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌id
     *
     * @param brandId 品牌id
     */
    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取库存数量
     *
     * @return store_count - 库存数量
     */
    public Short getStoreCount() {
        return storeCount;
    }

    /**
     * 设置库存数量
     *
     * @param storeCount 库存数量
     */
    public void setStoreCount(Short storeCount) {
        this.storeCount = storeCount;
    }

    /**
     * 获取商品评论数
     *
     * @return comment_count - 商品评论数
     */
    public Short getCommentCount() {
        return commentCount;
    }

    /**
     * 设置商品评论数
     *
     * @param commentCount 商品评论数
     */
    public void setCommentCount(Short commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取商品重量克为单位
     *
     * @return weight - 商品重量克为单位
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置商品重量克为单位
     *
     * @param weight 商品重量克为单位
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取市场价
     *
     * @return market_price - 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 设置市场价
     *
     * @param marketPrice 市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取本店价
     *
     * @return shop_price - 本店价
     */
    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    /**
     * 设置本店价
     *
     * @param shopPrice 本店价
     */
    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * 获取商品成本价
     *
     * @return cost_price - 商品成本价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * 设置商品成本价
     *
     * @param costPrice 商品成本价
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取商品关键词
     *
     * @return keywords - 商品关键词
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置商品关键词
     *
     * @param keywords 商品关键词
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取商品简单描述
     *
     * @return goods_remark - 商品简单描述
     */
    public String getGoodsRemark() {
        return goodsRemark;
    }

    /**
     * 设置商品简单描述
     *
     * @param goodsRemark 商品简单描述
     */
    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark;
    }

    /**
     * 获取商品详细描述
     *
     * @return goods_content - 商品详细描述
     */
    public String getGoodsContent() {
        return goodsContent;
    }

    /**
     * 设置商品详细描述
     *
     * @param goodsContent 商品详细描述
     */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    /**
     * 获取商品上传原始图
     *
     * @return original_img - 商品上传原始图
     */
    public String getOriginalImg() {
        return originalImg;
    }

    /**
     * 设置商品上传原始图
     *
     * @param originalImg 商品上传原始图
     */
    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg;
    }

    /**
     * 获取是否为实物
     *
     * @return is_real - 是否为实物
     */
    public Byte getIsReal() {
        return isReal;
    }

    /**
     * 设置是否为实物
     *
     * @param isReal 是否为实物
     */
    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    /**
     * 获取是否上架
     *
     * @return is_on_sale - 是否上架
     */
    public Byte getIsOnSale() {
        return isOnSale;
    }

    /**
     * 设置是否上架
     *
     * @param isOnSale 是否上架
     */
    public void setIsOnSale(Byte isOnSale) {
        this.isOnSale = isOnSale;
    }

    /**
     * 获取是否包邮0否1是
     *
     * @return is_free_shipping - 是否包邮0否1是
     */
    public Boolean getIsFreeShipping() {
        return isFreeShipping;
    }

    /**
     * 设置是否包邮0否1是
     *
     * @param isFreeShipping 是否包邮0否1是
     */
    public void setIsFreeShipping(Boolean isFreeShipping) {
        this.isFreeShipping = isFreeShipping;
    }

    /**
     * 获取商品上架时间
     *
     * @return on_time - 商品上架时间
     */
    public Integer getOnTime() {
        return onTime;
    }

    /**
     * 设置商品上架时间
     *
     * @param onTime 商品上架时间
     */
    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    /**
     * 获取商品排序
     *
     * @return sort - 商品排序
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置商品排序
     *
     * @param sort 商品排序
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取是否推荐
     *
     * @return is_recommend - 是否推荐
     */
    public Byte getIsRecommend() {
        return isRecommend;
    }

    /**
     * 设置是否推荐
     *
     * @param isRecommend 是否推荐
     */
    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取是否新品
     *
     * @return is_new - 是否新品
     */
    public Boolean getIsNew() {
        return isNew;
    }

    /**
     * 设置是否新品
     *
     * @param isNew 是否新品
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * 获取是否热卖
     *
     * @return is_hot - 是否热卖
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * 设置是否热卖
     *
     * @param isHot 是否热卖
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取最后更新时间
     *
     * @return last_update - 最后更新时间
     */
    public Integer getLastUpdate() {
        return lastUpdate;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdate 最后更新时间
     */
    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * 获取商品所属类型id，取值表goods_type的cat_id
     *
     * @return goods_type - 商品所属类型id，取值表goods_type的cat_id
     */
    public Short getGoodsType() {
        return goodsType;
    }

    /**
     * 设置商品所属类型id，取值表goods_type的cat_id
     *
     * @param goodsType 商品所属类型id，取值表goods_type的cat_id
     */
    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 获取商品规格类型，取值表goods_type的cat_id
     *
     * @return spec_type - 商品规格类型，取值表goods_type的cat_id
     */
    public Short getSpecType() {
        return specType;
    }

    /**
     * 设置商品规格类型，取值表goods_type的cat_id
     *
     * @param specType 商品规格类型，取值表goods_type的cat_id
     */
    public void setSpecType(Short specType) {
        this.specType = specType;
    }

    /**
     * 获取购买商品赠送积分
     *
     * @return give_integral - 购买商品赠送积分
     */
    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    /**
     * 设置购买商品赠送积分
     *
     * @param giveIntegral 购买商品赠送积分
     */
    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    /**
     * 获取积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     *
     * @return exchange_integral - 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    public Integer getExchangeIntegral() {
        return exchangeIntegral;
    }

    /**
     * 设置积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     *
     * @param exchangeIntegral 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    public void setExchangeIntegral(Integer exchangeIntegral) {
        this.exchangeIntegral = exchangeIntegral;
    }

    /**
     * 获取供货商ID
     *
     * @return suppliers_id - 供货商ID
     */
    public Short getSuppliersId() {
        return suppliersId;
    }

    /**
     * 设置供货商ID
     *
     * @param suppliersId 供货商ID
     */
    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    /**
     * 获取商品销量
     *
     * @return sales_sum - 商品销量
     */
    public Integer getSalesSum() {
        return salesSum;
    }

    /**
     * 设置商品销量
     *
     * @param salesSum 商品销量
     */
    public void setSalesSum(Integer salesSum) {
        this.salesSum = salesSum;
    }

    /**
     * 获取0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     *
     * @return prom_type - 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    public Boolean getPromType() {
        return promType;
    }

    /**
     * 设置0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     *
     * @param promType 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    public void setPromType(Boolean promType) {
        this.promType = promType;
    }

    /**
     * 获取优惠活动id
     *
     * @return prom_id - 优惠活动id
     */
    public Integer getPromId() {
        return promId;
    }

    /**
     * 设置优惠活动id
     *
     * @param promId 优惠活动id
     */
    public void setPromId(Integer promId) {
        this.promId = promId;
    }

    /**
     * 获取佣金用于分销分成
     *
     * @return commission - 佣金用于分销分成
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * 设置佣金用于分销分成
     *
     * @param commission 佣金用于分销分成
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * 获取SPU
     *
     * @return spu - SPU
     */
    public String getSpu() {
        return spu;
    }

    /**
     * 设置SPU
     *
     * @param spu SPU
     */
    public void setSpu(String spu) {
        this.spu = spu;
    }

    /**
     * 获取SKU
     *
     * @return sku - SKU
     */
    public String getSku() {
        return sku;
    }

    /**
     * 设置SKU
     *
     * @param sku SKU
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", catId=").append(catId);
        sb.append(", extendCatId=").append(extendCatId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", weight=").append(weight);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", keywords=").append(keywords);
        sb.append(", goodsRemark=").append(goodsRemark);
        sb.append(", goodsContent=").append(goodsContent);
        sb.append(", originalImg=").append(originalImg);
        sb.append(", isReal=").append(isReal);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", isFreeShipping=").append(isFreeShipping);
        sb.append(", onTime=").append(onTime);
        sb.append(", sort=").append(sort);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", specType=").append(specType);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", exchangeIntegral=").append(exchangeIntegral);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", salesSum=").append(salesSum);
        sb.append(", promType=").append(promType);
        sb.append(", promId=").append(promId);
        sb.append(", commission=").append(commission);
        sb.append(", spu=").append(spu);
        sb.append(", sku=").append(sku);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TGoods other = (TGoods) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getExtendCatId() == null ? other.getExtendCatId() == null : this.getExtendCatId().equals(other.getExtendCatId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getStoreCount() == null ? other.getStoreCount() == null : this.getStoreCount().equals(other.getStoreCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getShopPrice() == null ? other.getShopPrice() == null : this.getShopPrice().equals(other.getShopPrice()))
            && (this.getCostPrice() == null ? other.getCostPrice() == null : this.getCostPrice().equals(other.getCostPrice()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getGoodsRemark() == null ? other.getGoodsRemark() == null : this.getGoodsRemark().equals(other.getGoodsRemark()))
            && (this.getGoodsContent() == null ? other.getGoodsContent() == null : this.getGoodsContent().equals(other.getGoodsContent()))
            && (this.getOriginalImg() == null ? other.getOriginalImg() == null : this.getOriginalImg().equals(other.getOriginalImg()))
            && (this.getIsReal() == null ? other.getIsReal() == null : this.getIsReal().equals(other.getIsReal()))
            && (this.getIsOnSale() == null ? other.getIsOnSale() == null : this.getIsOnSale().equals(other.getIsOnSale()))
            && (this.getIsFreeShipping() == null ? other.getIsFreeShipping() == null : this.getIsFreeShipping().equals(other.getIsFreeShipping()))
            && (this.getOnTime() == null ? other.getOnTime() == null : this.getOnTime().equals(other.getOnTime()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getIsRecommend() == null ? other.getIsRecommend() == null : this.getIsRecommend().equals(other.getIsRecommend()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getGiveIntegral() == null ? other.getGiveIntegral() == null : this.getGiveIntegral().equals(other.getGiveIntegral()))
            && (this.getExchangeIntegral() == null ? other.getExchangeIntegral() == null : this.getExchangeIntegral().equals(other.getExchangeIntegral()))
            && (this.getSuppliersId() == null ? other.getSuppliersId() == null : this.getSuppliersId().equals(other.getSuppliersId()))
            && (this.getSalesSum() == null ? other.getSalesSum() == null : this.getSalesSum().equals(other.getSalesSum()))
            && (this.getPromType() == null ? other.getPromType() == null : this.getPromType().equals(other.getPromType()))
            && (this.getPromId() == null ? other.getPromId() == null : this.getPromId().equals(other.getPromId()))
            && (this.getCommission() == null ? other.getCommission() == null : this.getCommission().equals(other.getCommission()))
            && (this.getSpu() == null ? other.getSpu() == null : this.getSpu().equals(other.getSpu()))
            && (this.getSku() == null ? other.getSku() == null : this.getSku().equals(other.getSku()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getExtendCatId() == null) ? 0 : getExtendCatId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getStoreCount() == null) ? 0 : getStoreCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getShopPrice() == null) ? 0 : getShopPrice().hashCode());
        result = prime * result + ((getCostPrice() == null) ? 0 : getCostPrice().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getGoodsRemark() == null) ? 0 : getGoodsRemark().hashCode());
        result = prime * result + ((getGoodsContent() == null) ? 0 : getGoodsContent().hashCode());
        result = prime * result + ((getOriginalImg() == null) ? 0 : getOriginalImg().hashCode());
        result = prime * result + ((getIsReal() == null) ? 0 : getIsReal().hashCode());
        result = prime * result + ((getIsOnSale() == null) ? 0 : getIsOnSale().hashCode());
        result = prime * result + ((getIsFreeShipping() == null) ? 0 : getIsFreeShipping().hashCode());
        result = prime * result + ((getOnTime() == null) ? 0 : getOnTime().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getIsRecommend() == null) ? 0 : getIsRecommend().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getLastUpdate() == null) ? 0 : getLastUpdate().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getGiveIntegral() == null) ? 0 : getGiveIntegral().hashCode());
        result = prime * result + ((getExchangeIntegral() == null) ? 0 : getExchangeIntegral().hashCode());
        result = prime * result + ((getSuppliersId() == null) ? 0 : getSuppliersId().hashCode());
        result = prime * result + ((getSalesSum() == null) ? 0 : getSalesSum().hashCode());
        result = prime * result + ((getPromType() == null) ? 0 : getPromType().hashCode());
        result = prime * result + ((getPromId() == null) ? 0 : getPromId().hashCode());
        result = prime * result + ((getCommission() == null) ? 0 : getCommission().hashCode());
        result = prime * result + ((getSpu() == null) ? 0 : getSpu().hashCode());
        result = prime * result + ((getSku() == null) ? 0 : getSku().hashCode());
        return result;
    }
}