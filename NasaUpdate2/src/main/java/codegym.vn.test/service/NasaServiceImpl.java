package codegym.vn.test.service;

import codegym.vn.test.model.Nasa;
import codegym.vn.test.repository.INasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NasaServiceImpl implements INasaService {
    @Autowired
    INasaRepository repository;

    @Override
    public void create(Nasa nasa) {
        nasa.setDate();
        repository.save(nasa);

    }

    @Override
    public List<Nasa> findAll() {
        return (List<Nasa>) repository.findAll();
    }

    @Override
    public List<Nasa> findAllToday(String date) {
        return repository.findAllToday(date);
    }

    @Override
    public Nasa findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void addLike(Nasa nasa) {
        if (nasa.getLikes() != 0 ||nasa.getLikes()==0 ) {
            int newLike = nasa.getLikes() + 1;
            nasa.setLikes(newLike);
            repository.save(nasa);

        }
    }


    @Override
    public Page<Nasa> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Nasa> findAllWithSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
