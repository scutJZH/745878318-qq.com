package com.spring_cloud.management.service;

import com.spring_cloud.common.entity.PageQuery;
import com.spring_cloud.common.entity.PageResult;
import com.spring_cloud.common.entity.dto.CreateLabelDTO;
import com.spring_cloud.common.entity.dto.LabelDTO;

public interface ILabelService {
    void createLabel(CreateLabelDTO createLabelDTO) throws Exception;

    PageResult<LabelDTO> pageLabels(PageQuery pageQuery, String keyword);

    LabelDTO getById(Integer id);
}
