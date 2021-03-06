package com.xxxx.manager.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.common.utils.JsonUtil;
import com.xxxx.manager.mapper.TGoodsCategoryMapper;
import com.xxxx.manager.pojo.TGoodsCategory;
import com.xxxx.manager.service.TGoodsCategoryService;
import com.xxxx.manager.utils.AssertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TGoodsCategoryServiceImpl extends ServiceImpl<TGoodsCategoryMapper, TGoodsCategory> implements TGoodsCategoryService {

    @Autowired
    private TGoodsCategoryMapper goodsCategoryMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${goods.category.list.key}")
    private String goodsCategoryListKey;

    /**
     * 商品管理页面
     * 分层显示
     * 跳转商品分类的列表页
     *
     * @return
     */
    @Override
    public List<TGoodsCategory> listCategoryService() {
        List<TGoodsCategory> resultList = new ArrayList<>();

        List<TGoodsCategory> list=null;
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        //去redis中查询

        String s = valueOperations.get(goodsCategoryListKey);
        if (StringUtils.isEmpty(s)) {//redis中是否有数据
            //去数据库查询数据
            list = goodsCategoryMapper.listCategoryService();
            //将数据加到redis中
            valueOperations.set(goodsCategoryListKey, JsonUtil.object2JsonStr(list));
        }else{
            list = JsonUtil.jsonToList(s,TGoodsCategory.class);
        }

        //System.out.println(list);

        //对数据进行层级关系处理
        for (TGoodsCategory goodsCategory : list) {
            int id = goodsCategory.getId();
            List<TGoodsCategory> child = new ArrayList<>();
            for (TGoodsCategory deptChild : list) {
                if (id == deptChild.getParentId()) {
                    child.add(deptChild);
                }
            }
            goodsCategory.setChildren(child);
            if (goodsCategory.getParentId() == 0) {
                resultList.add(goodsCategory);
            }
        }
//        System.out.println(resultList);
        return resultList;


    }

    /**
     * 查询所有顶级分类
     */
    @Override
    public List<TGoodsCategory> selectCategoryTopList() {
        List<TGoodsCategory> list = goodsCategoryMapper.selectCategoryTopList();
        return list;
    }

    /*
     * 商品分类-新增分类-级联查询
     *   请选择商品分类
     * */
    @Override
    public List<TGoodsCategory> selectCategoryByParentId(Short parentId) {
        List<TGoodsCategory> list = goodsCategoryMapper.selectCategoryByParentId(parentId);
        return list;
    }

    /**
     * 保存分类
     *
     * @param goodsCategory
     * @return
     */
    @Override
    public boolean saveGoodsCategory(TGoodsCategory goodsCategory) {
        Byte sortOrder = goodsCategory.getSortOrder();
        if (sortOrder == null) {
            goodsCategory.setSortOrder((byte) 50);
        }
        AssertUtils.isTrue(goodsCategory.getSortOrder() < 0 | goodsCategory.getSortOrder() > 100, "请输入0-100之间的显示排序！", 500);
        AssertUtils.isTrue(goodsCategory.getIsShow() == null, "是否展示不能为空", 500);
        AssertUtils.isTrue(StringUtils.isBlank(goodsCategory.getName()), "分类名称不能为空", 500);
        AssertUtils.isTrue(StringUtils.isBlank(goodsCategory.getMobileName()), "手机分类名称不能为空", 500);
        if (goodsCategory.getIsHot() == null) {
            goodsCategory.setIsHot((byte) 1);//默认设置为1
        }
        /**
         * 保证redis数据一致性
         * 删除redis缓存
         */
        if (redisTemplate.hasKey(goodsCategoryListKey)) {//判断是否存在某个key
            redisTemplate.delete(goodsCategoryListKey);//删除某个key
        }
        //插入数据
        int i = goodsCategoryMapper.saveGoodsCategory(goodsCategory);
        //拼接parentIdPath  0_1_13_104
        //0_p1_p2_当前id
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0_");
        short s1 = goodsCategory.getParentId();
        if (s1 != 0) {
            stringBuilder.append(s1 + "_");
        }
        short s2 = goodsCategory.getParent_id_2();
        if (s2 != 0) {
            stringBuilder.append(s2 + "_");
        }
        stringBuilder.append(goodsCategory.getId());
        goodsCategory.setParentIdPath(stringBuilder.toString());
        System.out.println(stringBuilder);
        //更新parentidpath
        int b = goodsCategoryMapper.updateParentIdPathById(goodsCategory);
        return i > 0 && b > 0 ? true : false;
    }


}
