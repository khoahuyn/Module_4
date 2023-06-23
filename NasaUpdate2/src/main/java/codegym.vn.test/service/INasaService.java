package codegym.vn.test.service;


import codegym.vn.test.model.Nasa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface INasaService {
    void create(Nasa nasa);
    List<Nasa> findAll();
    List<Nasa> findAllToday(String date);
    Nasa findById(Integer id);
    void addLike(Nasa nasa);

    Page<Nasa> findAllWithPaging(Pageable pageable);
    Slice<Nasa> findAllWithSlice(Pageable pageable);
}
