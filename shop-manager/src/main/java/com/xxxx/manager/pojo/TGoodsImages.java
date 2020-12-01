package com.xxxx.manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "t_goods_images")
public class TGoodsImages {
    /**
     * 图片id 自增
     */
    @TableId(value = "img_id", type = IdType.INPUT)
    private Integer imgId;

    /**
     * 商品id
     */
    @TableField(value = "goods_id")
    private Integer goodsId;

    /**
     * 图片地址
     */
    @TableField(value = "image_url")
    private String imageUrl;

    public static final String COL_IMG_ID = "img_id";

    public static final String COL_GOODS_ID = "goods_id";

    public static final String COL_IMAGE_URL = "image_url";

    /**
     * 获取图片id 自增
     *
     * @return img_id - 图片id 自增
     */
    public Integer getImgId() {
        return imgId;
    }

    /**
     * 设置图片id 自增
     *
     * @param imgId 图片id 自增
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

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
     * 获取图片地址
     *
     * @return image_url - 图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imageUrl 图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", imageUrl=").append(imageUrl);
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
        TGoodsImages other = (TGoodsImages) that;
        return (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        return result;
    }
}