package com.spring_cloud.management.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring_cloud.management.dao.IBookDAO;
import com.spring_cloud.management.dao.IBookLabelDAO;
import com.spring_cloud.management.dao.ILabelDAO;
import com.spring_cloud.management.entity.domain.Book;
import com.spring_cloud.management.entity.domain.Label;
import com.spring_cloud.common.entity.po.BookLabelPO;
import com.spring_cloud.common.entity.po.BookPO;
import com.spring_cloud.common.entity.po.LabelPO;
import com.spring_cloud.management.factory.IBookFactory;
import com.spring_cloud.management.repository.IBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRepositoryImpl implements IBookRepository {

    @Resource
    private IBookFactory bookFactory;
    @Resource
    private IBookDAO bookDAO;
    @Resource
    private ILabelDAO labelDAO;
    @Resource
    private IBookLabelDAO bookLabelDAO;

    @Override
    public void store(Book book) {
        BookPO bookPO = new BookPO();
        BeanUtils.copyProperties(book, bookPO);
        bookPO.setType(book.getType().getTypeId());

        if(bookPO.getId() == null) {
            bookDAO.insert(bookPO);
        } else {
            bookDAO.updateById(bookPO);
            bookLabelDAO.delete(new QueryWrapper<BookLabelPO>().eq("book_id", bookPO.getId()));
        }
        for(Label label : book.getLabels()) {
            BookLabelPO bookLabelPO = new BookLabelPO();
            bookLabelPO.setBookId(bookPO.getId());
            bookLabelPO.setLabelId(label.getId());
        }
    }

    @Override
    public Book findById(Integer id) {
        BookPO bookPO = bookDAO.selectById(id);
        if(bookPO == null) {
            return null;
        }
        List<BookLabelPO> bookLabelPOList = bookLabelDAO.selectList(new QueryWrapper<BookLabelPO>().eq("book_id", id));
        List<Integer> labelIds = bookLabelPOList.stream().map(BookLabelPO::getLabelId).collect(Collectors.toList());
        List<LabelPO> labelPOList;
        if(labelIds.size() == 0) {
            labelPOList = new ArrayList<>();
        } else {
            labelPOList = labelDAO.selectList(new QueryWrapper<LabelPO>().in("id", labelIds));
        }
        return bookFactory.assembleBook(bookPO, labelPOList);
    }
}
