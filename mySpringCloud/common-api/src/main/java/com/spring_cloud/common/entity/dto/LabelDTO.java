package com.spring_cloud.common.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LabelDTO {
    private Integer id;
    private String name;
    private Date createTime;
}
