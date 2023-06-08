package test.repository;

import org.springframework.stereotype.Repository;
import test.model.Nasa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NasaRepositoryImpl implements INasaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(Nasa nasa) {
        entityManager.persist(nasa);
        nasa.setLikes(nasa.getLikes()+1);
        nasa.setDate();
    }

    @Override
    public List<Nasa> findAll() {
        return entityManager.createQuery("select c from Nasa c").getResultList();
    }


    @Override
    public List<Nasa> findAllToday(String date) {
        return entityManager.createQuery("select c from Nasa c where c.date=?1").setParameter(1,date).getResultList();
    }
}
