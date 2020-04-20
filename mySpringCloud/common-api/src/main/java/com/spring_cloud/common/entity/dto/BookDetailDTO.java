package com.spring_cloud.common.entity.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookDetailDTO {
    private Integer id;
    private String name;
    private String description;
    private String author;
    private Integer type;
    private Integer number;
    private Float purchasePrice;
    private Float price;
    private Float discount;
    private Date publishingTime;
    private List<LabelDTO> labels;
    private Date createTime;
}
