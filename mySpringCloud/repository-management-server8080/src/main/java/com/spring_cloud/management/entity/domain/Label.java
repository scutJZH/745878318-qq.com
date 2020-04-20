package com.spring_cloud.management.entity.domain;

import com.spring_cloud.common.entity.po.LabelPO;
import lombok.Getter;

import java.util.Date;

@Getter
public class Label {
    private Integer id;
    private String name;
    private Date createTime;

    public Label(LabelPO labelPO) {
        this.id = labelPO.getId();
        this.name = labelPO.getName();
        this.createTime = labelPO.getCreateTime();
    }

}
