package com.spring_cloud.management.client.controller;

import com.spring_cloud.common.entity.RespResult;
import com.spring_cloud.common.entity.dto.BookDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/books")
public class BookController {

    @PostMapping
    public RespResult<Void> createBook(BookDTO bookDTO) {
        return null;
    }
}
