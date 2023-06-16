package test.service;




import test.model.Nasa;

import java.util.List;

public interface INasaService {
    void create(Nasa nasa);
    List<Nasa> findAll();
    List<Nasa> findAllToday(String date);
    Nasa findById(Integer id);
    void addLike(Nasa nasa);
}
