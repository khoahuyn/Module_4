package codegym.vn.test.service;



import codegym.vn.test.model.Book;
import codegym.vn.test.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBorrowService {
    void create(Borrow borrow);
    List<Borrow> findAll();
    Borrow findById(Integer userId);
    void update(Borrow borrow);

    Page<Borrow> findAllWithPaging(Pageable pageable);
    Slice<Borrow> findAllWithSlice(Pageable pageable);


}
