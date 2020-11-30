package com.xxxx.manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "t_goods_category")
public class TGoodsCategory {
    /**
     * 商品分类id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Short id;

    /**
     * 商品分类名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 手机端显示的商品分类名
     */
    @TableField(value = "mobile_name")
    private String mobileName;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    private Short parentId;

    /**
     * 家族图谱
     */
    @TableField(value = "parent_id_path")
    private String parentIdPath;

    /**
     * 等级
     */
    @TableField(value = "`level`")
    private Boolean level;

    /**
     * 顺序排序
     */
    @TableField(value = "sort_order")
    private Boolean sortOrder;

    /**
     * 是否显示
     */
    @TableField(value = "is_show")
    private Boolean isShow;

    /**
     * 分类图片
     */
    @TableField(value = "image")
    private String image;

    /**
     * 是否推荐为热门分类
     */
    @TableField(value = "is_hot")
    private Boolean isHot;

    /**
     * 分类分组默认0
     */
    @TableField(value = "cat_group")
    private Boolean catGroup;

    /**
     * 分佣比例
     */
    @TableField(value = "commission_rate")
    private Boolean commissionRate;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_MOBILE_NAME = "mobile_name";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_PARENT_ID_PATH = "parent_id_path";

    public static final String COL_LEVEL = "level";

    public static final String COL_SORT_ORDER = "sort_order";

    public static final String COL_IS_SHOW = "is_show";

    public static final String COL_IMAGE = "image";

    public static final String COL_IS_HOT = "is_hot";

    public static final String COL_CAT_GROUP = "cat_group";

    public static final String COL_COMMISSION_RATE = "commission_rate";

    /**
     * 获取商品分类id
     *
     * @return id - 商品分类id
     */
    public Short getId() {
        return id;
    }

    /**
     * 设置商品分类id
     *
     * @param id 商品分类id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 获取商品分类名称
     *
     * @return name - 商品分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品分类名称
     *
     * @param name 商品分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机端显示的商品分类名
     *
     * @return mobile_name - 手机端显示的商品分类名
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * 设置手机端显示的商品分类名
     *
     * @param mobileName 手机端显示的商品分类名
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    /**
     * 获取父id
     *
     * @return parent_id - 父id
     */
    public Short getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取家族图谱
     *
     * @return parent_id_path - 家族图谱
     */
    public String getParentIdPath() {
        return parentIdPath;
    }

    /**
     * 设置家族图谱
     *
     * @param parentIdPath 家族图谱
     */
    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath;
    }

    /**
     * 获取等级
     *
     * @return level - 等级
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level 等级
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * 获取顺序排序
     *
     * @return sort_order - 顺序排序
     */
    public Boolean getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置顺序排序
     *
     * @param sortOrder 顺序排序
     */
    public void setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取是否显示
     *
     * @return is_show - 是否显示
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示
     *
     * @param isShow 是否显示
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取分类图片
     *
     * @return image - 分类图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置分类图片
     *
     * @param image 分类图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取是否推荐为热门分类
     *
     * @return is_hot - 是否推荐为热门分类
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * 设置是否推荐为热门分类
     *
     * @param isHot 是否推荐为热门分类
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取分类分组默认0
     *
     * @return cat_group - 分类分组默认0
     */
    public Boolean getCatGroup() {
        return catGroup;
    }

    /**
     * 设置分类分组默认0
     *
     * @param catGroup 分类分组默认0
     */
    public void setCatGroup(Boolean catGroup) {
        this.catGroup = catGroup;
    }

    /**
     * 获取分佣比例
     *
     * @return commission_rate - 分佣比例
     */
    public Boolean getCommissionRate() {
        return commissionRate;
    }

    /**
     * 设置分佣比例
     *
     * @param commissionRate 分佣比例
     */
    public void setCommissionRate(Boolean commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mobileName=").append(mobileName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIdPath=").append(parentIdPath);
        sb.append(", level=").append(level);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isShow=").append(isShow);
        sb.append(", image=").append(image);
        sb.append(", isHot=").append(isHot);
        sb.append(", catGroup=").append(catGroup);
        sb.append(", commissionRate=").append(commissionRate);
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
        TGoodsCategory other = (TGoodsCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobileName() == null ? other.getMobileName() == null : this.getMobileName().equals(other.getMobileName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getParentIdPath() == null ? other.getParentIdPath() == null : this.getParentIdPath().equals(other.getParentIdPath()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getCatGroup() == null ? other.getCatGroup() == null : this.getCatGroup().equals(other.getCatGroup()))
            && (this.getCommissionRate() == null ? other.getCommissionRate() == null : this.getCommissionRate().equals(other.getCommissionRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobileName() == null) ? 0 : getMobileName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentIdPath() == null) ? 0 : getParentIdPath().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getCatGroup() == null) ? 0 : getCatGroup().hashCode());
        result = prime * result + ((getCommissionRate() == null) ? 0 : getCommissionRate().hashCode());
        return result;
    }
}