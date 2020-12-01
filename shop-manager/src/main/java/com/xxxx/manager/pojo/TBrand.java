package com.xxxx.manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "t_brand")
public class TBrand {
    /**
     * 品牌表
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Short id;

    /**
     * 品牌名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 品牌logo
     */
    @TableField(value = "logo")
    private String logo;

    /**
     * 品牌描述
     */
    @TableField(value = "`desc`")
    private String desc;

    /**
     * 品牌地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Byte sort;

    /**
     * 品牌分类
     */
    @TableField(value = "cat_name")
    private String catName;

    /**
     * 分类id
     */
    @TableField(value = "parent_cat_id")
    private Integer parentCatId;

    /**
     * 分类id
     */
    @TableField(value = "cat_id")
    private Integer catId;

    /**
     * 是否推荐
     */
    @TableField(value = "is_hot")
    private Boolean isHot;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_LOGO = "logo";

    public static final String COL_DESC = "desc";

    public static final String COL_URL = "url";

    public static final String COL_SORT = "sort";

    public static final String COL_CAT_NAME = "cat_name";

    public static final String COL_PARENT_CAT_ID = "parent_cat_id";

    public static final String COL_CAT_ID = "cat_id";

    public static final String COL_IS_HOT = "is_hot";

    /**
     * 获取品牌表
     *
     * @return id - 品牌表
     */
    public Short getId() {
        return id;
    }

    /**
     * 设置品牌表
     *
     * @param id 品牌表
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 获取品牌名称
     *
     * @return name - 品牌名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置品牌名称
     *
     * @param name 品牌名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取品牌logo
     *
     * @return logo - 品牌logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置品牌logo
     *
     * @param logo 品牌logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取品牌描述
     *
     * @return desc - 品牌描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置品牌描述
     *
     * @param desc 品牌描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取品牌地址
     *
     * @return url - 品牌地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置品牌地址
     *
     * @param url 品牌地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * 获取品牌分类
     *
     * @return cat_name - 品牌分类
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 设置品牌分类
     *
     * @param catName 品牌分类
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     * 获取分类id
     *
     * @return parent_cat_id - 分类id
     */
    public Integer getParentCatId() {
        return parentCatId;
    }

    /**
     * 设置分类id
     *
     * @param parentCatId 分类id
     */
    public void setParentCatId(Integer parentCatId) {
        this.parentCatId = parentCatId;
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
     * 获取是否推荐
     *
     * @return is_hot - 是否推荐
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * 设置是否推荐
     *
     * @param isHot 是否推荐
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", logo=").append(logo);
        sb.append(", desc=").append(desc);
        sb.append(", url=").append(url);
        sb.append(", sort=").append(sort);
        sb.append(", catName=").append(catName);
        sb.append(", parentCatId=").append(parentCatId);
        sb.append(", catId=").append(catId);
        sb.append(", isHot=").append(isHot);
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
        TBrand other = (TBrand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getCatName() == null ? other.getCatName() == null : this.getCatName().equals(other.getCatName()))
            && (this.getParentCatId() == null ? other.getParentCatId() == null : this.getParentCatId().equals(other.getParentCatId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCatName() == null) ? 0 : getCatName().hashCode());
        result = prime * result + ((getParentCatId() == null) ? 0 : getParentCatId().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        return result;
    }
}