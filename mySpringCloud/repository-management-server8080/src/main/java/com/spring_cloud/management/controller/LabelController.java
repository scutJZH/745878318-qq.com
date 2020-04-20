package com.spring_cloud.management.controller;


import com.spring_cloud.common.entity.PageQuery;
import com.spring_cloud.common.entity.PageResult;
import com.spring_cloud.common.entity.RespResult;
import com.spring_cloud.common.entity.dto.CreateLabelDTO;
import com.spring_cloud.common.entity.dto.LabelDTO;
import com.spring_cloud.management.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private ILabelService labelService;

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public RespResult<Void> createLabel(@Valid @RequestBody CreateLabelDTO createLabelDTO) throws Exception {
        labelService.createLabel(createLabelDTO);
        return new RespResult<>();
    }

    @GetMapping
    public RespResult<PageResult<LabelDTO>> pageLabels(@RequestParam("page_no") Long pageNo,
                                           @RequestParam("page_size") Long pageSize,
                                           @RequestParam(value = "sort_by", defaultValue = "id") String sortBy,
                                           @RequestParam(value = "sort_direction", defaultValue = "asc") String sortDirection,
                                           @RequestParam(value = "keyword", required = false) String keyword) {
        PageQuery pageQuery = new PageQuery(pageNo, pageSize, sortBy, sortDirection);
        return new RespResult<>(labelService.pageLabels(pageQuery, keyword));
    }

    @GetMapping("/{id}")
    public RespResult<LabelDTO> getById(@PathVariable("id") Integer id) {
        return new RespResult<>(labelService.getById(id));
    }
}
