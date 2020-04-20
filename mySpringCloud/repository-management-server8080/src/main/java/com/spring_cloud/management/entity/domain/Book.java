package com.spring_cloud.management.entity.domain;

import com.spring_cloud.common.entity.AggregateRoot;
import com.spring_cloud.common.entity.enumeration.BookType;
import com.spring_cloud.common.entity.po.BookPO;
import com.spring_cloud.common.entity.po.LabelPO;
import com.spring_cloud.exception.FatalError;
import com.spring_cloud.common.entity.dto.BookDTO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Book implements IBook, AggregateRoot {
    private Integer id;
    private String name;
    private String description;
    private String author;
    private BookType type;
    private Integer number;
    private Float purchasePrice;
    private Float price;
    private Float discount;
    private Date publishingTime;
    private List<Label> labels;
    private Date createTime;

    public Book(BookDTO bookDTO, List<LabelPO> labelPOList) throws Exception {
        this.name = bookDTO.getName();
        this.description = bookDTO.getDescription();
        this.author = bookDTO.getAuthor();
        this.number = bookDTO.getNumber();
        this.purchasePrice = bookDTO.getPurchasePrice();
        this.price = bookDTO.getPrice();
        this.discount = bookDTO.getDiscount();
        this.publishingTime = bookDTO.getPublishingTime();
        type = BookType.getBookType(bookDTO.getType());
        if(type == null) {
            throw new Exception();
        }
        if(labelPOList == null) {
            this.labels = new ArrayList<>();
        }
        this.labels = labelPOList.stream().map(Label::new).collect(Collectors.toList());
    }

    public Book(BookPO bookPO, List<LabelPO> labelPOList) {
        this.id = bookPO.getId();
        this.name = bookPO.getName();
        this.description = bookPO.getDescription();
        this.author = bookPO.getAuthor();
        this.number = bookPO.getNumber();
        this.purchasePrice = bookPO.getPurchasePrice();
        this.price = bookPO.getPrice();
        this.discount = bookPO.getDiscount();
        this.publishingTime = bookPO.getPublishingTime();
        this.type = BookType.getBookType(bookPO.getType());
        this.createTime = bookPO.getCreateTime();
        if(type == null) {
            throw new FatalError("bookType不正确");
        }
        if(labelPOList == null) {
            this.labels = new ArrayList<>();
        }
        this.labels = labelPOList.stream().map(Label::new).collect(Collectors.toList());
    }

    @Override
    public void addBookNumber(Integer number) throws Exception {
        if(number <= 0) {
            throw new Exception();
        }
        this.number += number;
    }

    @Override
    public void reduceBookNumber(Integer number) throws Exception {
        if(number <= 0) {
            throw new Exception();
        }
        if(number > this.number) {
            throw new Exception();
        }
        this.number -= number;
    }
}
