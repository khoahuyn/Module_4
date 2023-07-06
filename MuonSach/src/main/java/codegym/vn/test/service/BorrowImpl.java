package codegym.vn.test.service;



import codegym.vn.test.model.Borrow;
import codegym.vn.test.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowImpl implements IBorrowService {

    @Autowired
    IBorrowRepository repository;

    @Override
    public void create(Borrow borrow) {
        repository.save(borrow);
    }

    @Override
    public List<Borrow> findAll() {
        return  repository.findAll();
    }

    @Override
    public Borrow findById(Integer userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public void update(Borrow borrow) {
        if (repository.existsById(borrow.getUserId())){
            repository.save(borrow);
        }
    }

    @Override
    public Page<Borrow> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Borrow> findAllWithSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
