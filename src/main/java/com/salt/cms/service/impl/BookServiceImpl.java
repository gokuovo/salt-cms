package com.salt.cms.service.impl;

import com.salt.cms.dto.book.CreateOrUpdateBookDTO;
import com.salt.cms.mapper.BookMapper;
import com.salt.cms.model.BookDO;
import com.salt.cms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean createBook(CreateOrUpdateBookDTO validator) {
        BookDO book = new BookDO();
        book.setAuthor(validator.getAuthor());
        book.setTitle(validator.getTitle());
        book.setImage(validator.getImage());
        book.setSummary(validator.getSummary());
        return bookMapper.insert(book) > 0;
    }

    @Override
    public List<BookDO> getBookByKeyword(String q) {
        List<BookDO> books = bookMapper.selectByTitleLikeKeyword(q);
        return books;
    }

    @Override
    public boolean updateBook(BookDO book, CreateOrUpdateBookDTO validator) {
        book.setAuthor(validator.getAuthor());
        book.setTitle(validator.getTitle());
        book.setImage(validator.getImage());
        book.setSummary(validator.getSummary());
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public BookDO getById(Integer id) {
        BookDO book = bookMapper.selectById(id);
        return book;
    }

    @Override
    public List<BookDO> findAll() {
        List<BookDO> books = bookMapper.selectList(null);
        return books;
    }

    @Override
    public boolean deleteById(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }
}
