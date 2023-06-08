package test.repository;




import test.model.Nasa;

import java.util.List;

public interface INasaRepository {
    void create(Nasa nasa);
    List<Nasa> findAll();
    List<Nasa> findAllToday(String date);
}
