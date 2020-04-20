package com.spring_cloud.common.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class BookPO {
    @TableId
    private Integer id;
    private String name;
    private String description;
    private String author;
    private Integer type;
    private Integer number;
    @TableField("purchase_price")
    private Float purchasePrice;
    private Float price;
    private Float discount;
    @TableField("publishing_time")
    private Date publishingTime;
    @TableField("create_time")
    private Date createTime;
}
