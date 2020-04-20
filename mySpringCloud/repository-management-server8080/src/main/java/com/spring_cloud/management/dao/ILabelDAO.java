package com.spring_cloud.management.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring_cloud.common.entity.po.LabelPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ILabelDAO extends BaseMapper<LabelPO> {
}
