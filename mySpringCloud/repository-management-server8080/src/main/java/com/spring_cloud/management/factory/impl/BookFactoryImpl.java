package com.spring_cloud.management.factory.impl;

import com.spring_cloud.management.entity.domain.Book;
import com.spring_cloud.common.entity.dto.BookDTO;
import com.spring_cloud.common.entity.po.BookPO;
import com.spring_cloud.common.entity.po.LabelPO;
import com.spring_cloud.management.factory.IBookFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookFactoryImpl implements IBookFactory {
    @Override
    public Book newBook(BookDTO bookDTO, List<LabelPO> labelPOList) throws Exception {
        return new Book(bookDTO, labelPOList);
    }

    @Override
    public Book assembleBook(BookPO bookPO, List<LabelPO> labelPOList) {
        return new Book(bookPO, labelPOList);
    }
}
