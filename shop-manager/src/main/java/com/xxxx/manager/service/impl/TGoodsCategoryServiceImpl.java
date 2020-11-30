package com.xxxx.manager.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.manager.pojo.TGoodsCategory;
import com.xxxx.manager.mapper.TGoodsCategoryMapper;
import com.xxxx.manager.service.TGoodsCategoryService;
@Service
public class TGoodsCategoryServiceImpl extends ServiceImpl<TGoodsCategoryMapper, TGoodsCategory> implements TGoodsCategoryService{

}
