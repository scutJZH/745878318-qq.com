package com.spring_cloud.common.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String author;
    @NotBlank
    private String type;
    @NotNull
    @Range(min = 0)
    private Integer number;
    @NotNull
    @Range(min = 0)
    private Float purchasePrice;
    @NotNull
    @Range(min = 0)
    private Float price;
    @Range(min = 0, max = 10)
    private Float discount;
    @NotNull
    private Date publishingTime;
    @NotNull
    private List<Integer> labelIds;
}
