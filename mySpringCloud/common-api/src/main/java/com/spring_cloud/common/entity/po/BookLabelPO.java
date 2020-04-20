package com.spring_cloud.common.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book_label")
public class BookLabelPO {
    @TableId
    private Integer id;
    @TableField("book_id")
    private Integer bookId;
    @TableField("label_id")
    private Integer labelId;
}
