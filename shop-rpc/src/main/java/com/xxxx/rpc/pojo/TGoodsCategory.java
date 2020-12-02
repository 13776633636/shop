package com.xxxx.rpc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;


public class TGoodsCategory implements Serializable {

    /**
     * 查询用的字段
     *
     */
    @TableField(exist = false)
    private  Short parent_id_1;
    @TableField(exist = false)
    private  Short parent_id_2;

    public Short getParent_id_1() {
        return parent_id_1;
    }

    public void setParent_id_1(Short parent_id_1) {
        this.parent_id_1 = parent_id_1;
    }

    public Short getParent_id_2() {
        return parent_id_2;
    }

    public void setParent_id_2(Short parent_id_2) {
        this.parent_id_2 = parent_id_2;
    }

    /**
     * 商品分类id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Short id;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 手机端显示的商品分类名
     */
    private String mobileName;

    /**
     * 父id
     */
    private Short parentId;

    /**
     * 家族图谱
     */
    private String parentIdPath;

    /**
     * 等级
     */
    private Byte level;

    /**
     * 顺序排序
     */
    private Byte sortOrder;

    /**
     * 是否显示
     */
    private Byte isShow;

    /**
     * 分类图片
     */
    private String image;

    /**
     * 是否推荐为热门分类
     */
    private Byte isHot;

    /**
     * 分类分组默认0
     */
    private Byte catGroup;

    /**
     * 分佣比例
     */
    private Byte commissionRate;

    /*子商品分类
     * */
    @TableField(exist = false)
    private List<TGoodsCategory> children;
    /**
     * t_goods_category
     */
    private static final long serialVersionUID = 1L;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public String getParentIdPath() {
        return parentIdPath;
    }

    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getCatGroup() {
        return catGroup;
    }

    public void setCatGroup(Byte catGroup) {
        this.catGroup = catGroup;
    }

    public Byte getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Byte commissionRate) {
        this.commissionRate = commissionRate;
    }

    public List<TGoodsCategory> getChildren() {
        return children;
    }

    public void setChildren(List<TGoodsCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TGoodsCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileName='" + mobileName + '\'' +
                ", parentId=" + parentId +
                ", parentIdPath='" + parentIdPath + '\'' +
                ", level=" + level +
                ", sortOrder=" + sortOrder +
                ", isShow=" + isShow +
                ", image='" + image + '\'' +
                ", isHot=" + isHot +
                ", catGroup=" + catGroup +
                ", commissionRate=" + commissionRate +
                ", children=" + children +
                '}';
    }
}
