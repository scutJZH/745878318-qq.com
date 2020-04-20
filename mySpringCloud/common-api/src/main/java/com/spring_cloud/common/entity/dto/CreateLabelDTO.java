package com.spring_cloud.common.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class CreateLabelDTO {
    @NotBlank
    @Length(min = 0, max = 100)
    private String name;
}
