package com.spring_cloud.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring_cloud.common.entity.PageQuery;
import com.spring_cloud.common.entity.PageResult;
import com.spring_cloud.common.util.PageUtils;
import com.spring_cloud.management.dao.ILabelDAO;
import com.spring_cloud.common.entity.dto.CreateLabelDTO;
import com.spring_cloud.common.entity.dto.LabelDTO;
import com.spring_cloud.common.entity.po.LabelPO;
import com.spring_cloud.management.service.ILabelService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl implements ILabelService {

    @Resource
    private ILabelDAO labelDAO;

    @Override
    public void createLabel(CreateLabelDTO createLabelDTO) throws Exception {
        LabelPO labelPO = labelDAO.selectOne(new QueryWrapper<LabelPO>().eq("name", createLabelDTO.getName()));
        if(labelPO != null) {
            throw new Exception();
        }
        labelPO = new LabelPO();
        labelPO.setName(createLabelDTO.getName());
        labelDAO.insert(labelPO);
    }

    @Override
    public PageResult<LabelDTO> pageLabels(PageQuery pageQuery, String keyword) {
        Page<LabelPO> page = PageUtils.buildPage(pageQuery);
        IPage<LabelPO> labelPOPage = labelDAO.selectPage(page, new QueryWrapper<LabelPO>()
                .like(!StringUtils.isBlank(keyword), "name", keyword));
        List<LabelDTO> labelDTOList = labelPOPage.getRecords().stream()
                .map(labelPO -> {
                    LabelDTO labelDTO = new LabelDTO();
                    BeanUtils.copyProperties(labelPO, labelDTO);
                    return labelDTO;
                }).collect(Collectors.toList());
        return new PageResult<>(labelPOPage.getTotal(), labelDTOList);
    }

    @Override
    public LabelDTO getById(Integer id) {
        LabelPO labelPO = labelDAO.selectById(id);
        if(labelPO == null) {
            return null;
        }
        LabelDTO labelDTO = new LabelDTO();
        BeanUtils.copyProperties(labelPO, labelDTO);
        return labelDTO;
    }
}
