package codegym.vn.test.service;


import codegym.vn.test.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBookService {
    void create(Book book);
    List<Book> findAll();
    Book findById(Integer bookId);
    void update(Book book);
    void deleteById(Integer bookId);
    List<Book> findAllByName(String name);

    Page<Book> findAllWithPaging(Pageable pageable);
    Slice<Book> findAllWithSlice(Pageable pageable);
}
