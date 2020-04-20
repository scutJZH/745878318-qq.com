package com.spring_cloud.management.service;

import com.spring_cloud.common.entity.dto.BookDTO;
import com.spring_cloud.common.entity.dto.BookDetailDTO;

public interface IBookService {
    void createBook(BookDTO bookDTO) throws Exception;

    BookDetailDTO getBookById(Integer id);
}
