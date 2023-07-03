package codegym.vn.test.service;


import codegym.vn.test.model.Book;
import codegym.vn.test.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepository repository;

    @Override
    public void create(Book book) {
        repository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) repository.findAll();
    }

    @Override
    public Book findById(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public void update(Book book) {
        if (repository.existsById(book.getBookId())){
            repository.save(book);
        }
    }

    @Override
    public void deleteById(Integer bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public List<Book> findAllByName(String name) {
        return repository.findAllByName("%"+name+"%");
    }



    @Override
    public Page<Book> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Book> findAllWithSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
