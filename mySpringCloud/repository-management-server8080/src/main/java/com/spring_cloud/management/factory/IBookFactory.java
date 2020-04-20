package com.spring_cloud.management.factory;

import com.spring_cloud.management.entity.domain.Book;
import com.spring_cloud.common.entity.dto.BookDTO;
import com.spring_cloud.common.entity.po.BookPO;
import com.spring_cloud.common.entity.po.LabelPO;

import java.util.List;

public interface IBookFactory {
    Book newBook(BookDTO bookDTO, List<LabelPO> labelPOList) throws Exception;

    Book assembleBook(BookPO bookPO, List<LabelPO> labelPOList);
}
