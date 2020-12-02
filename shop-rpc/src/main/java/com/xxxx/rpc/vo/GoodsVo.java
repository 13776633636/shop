package com.xxxx.rpc.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsVo implements Serializable {

    private Integer goodsId;//商品id
    private String goodsName;//商品名称
    private String goodsNameHl;//高亮信息
    private BigDecimal marketPrice;//市场价格
    private String originalImg;//原始图片


    public GoodsVo() {
    }

    public GoodsVo(Integer goodsId, String goodsName, String goodsNameHl, BigDecimal marketPrice, String originalImg) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsNameHl = goodsNameHl;
        this.marketPrice = marketPrice;
        this.originalImg = originalImg;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNameHl='" + goodsNameHl + '\'' +
                ", marketPrice=" + marketPrice +
                ", originalImg='" + originalImg + '\'' +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNameHl() {
        return goodsNameHl;
    }

    public void setGoodsNameHl(String goodsNameHl) {
        this.goodsNameHl = goodsNameHl;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getOriginalImg() {
        return originalImg;
    }

    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg;
    }
}
