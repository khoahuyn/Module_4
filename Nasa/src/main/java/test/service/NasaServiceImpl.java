package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Nasa;
import test.repository.INasaRepository;


import java.util.List;

@Service
public class NasaServiceImpl implements INasaService {
    @Autowired
    INasaRepository repository;
    @Override
    public void create(Nasa nasa) {
        repository.create(nasa);
    }

    @Override
    public List<Nasa> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Nasa> findAllToday(String date) {
        return repository.findAllToday(date);
    }

}
