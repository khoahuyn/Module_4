package codegym.vn.test.service;



import codegym.vn.test.model.Borrow;

import java.util.List;

public interface IBorrowService {
    void create(Borrow borrow);
    List<Borrow> findAll();
    Borrow findById(Integer userId);
    void update(Borrow borrow);


}
