package com.spring_cloud.management.service.impl;

import com.spring_cloud.common.entity.dto.LabelDTO;
import com.spring_cloud.management.dao.ILabelDAO;
import com.spring_cloud.management.entity.domain.Book;
import com.spring_cloud.common.entity.dto.BookDTO;
import com.spring_cloud.common.entity.dto.BookDetailDTO;
import com.spring_cloud.common.entity.po.LabelPO;
import com.spring_cloud.management.factory.IBookFactory;
import com.spring_cloud.management.repository.IBookRepository;
import com.spring_cloud.management.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private IBookFactory bookFactory;
    @Resource
    private IBookRepository bookRepository;
    @Resource
    private ILabelDAO labelDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBook(BookDTO bookDTO) throws Exception {
        List<Integer> labelIds = bookDTO.getLabelIds();
        List<LabelPO> labelPOList = labelDAO.selectBatchIds(labelIds);
        Book book = bookFactory.newBook(bookDTO, labelPOList);
        bookRepository.store(book);
    }

    @Override
    public BookDetailDTO getBookById(Integer id) {
        Book book = bookRepository.findById(id);
        if(book == null) {
            return null;
        }
        BookDetailDTO bookDetailDTO = transferBookToDTO(book);
        return bookDetailDTO;
    }

    private BookDetailDTO transferBookToDTO(Book book) {
        BookDetailDTO bookDetailDTO = new BookDetailDTO();
        BeanUtils.copyProperties(book, bookDetailDTO);
        List<LabelDTO> labelDTOList = book.getLabels().stream()
                .map(label -> {
                    LabelDTO labelDTO = new LabelDTO();
                    BeanUtils.copyProperties(label, labelDTO);
                    return labelDTO;
                }).collect(Collectors.toList());
        bookDetailDTO.setLabels(labelDTOList);
        return bookDetailDTO;
    }
}
