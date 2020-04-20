package com.spring_cloud.management.controller;

import com.spring_cloud.common.entity.RespResult;
import com.spring_cloud.common.entity.dto.BookDTO;
import com.spring_cloud.common.entity.dto.BookDetailDTO;
import com.spring_cloud.management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public RespResult<Void> createBook(@Valid @RequestBody BookDTO bookDTO) throws Exception {
        bookService.createBook(bookDTO);
        return new RespResult<>();
    }

    @GetMapping("/{id}")
    public RespResult<BookDetailDTO> getById(@PathVariable("id") Integer id) {
        return new RespResult<>(bookService.getBookById(id));
    }
}
