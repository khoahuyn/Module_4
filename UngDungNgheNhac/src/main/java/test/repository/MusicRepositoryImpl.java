package test.repository;

import org.springframework.stereotype.Repository;
import test.model.Music;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void create(Music music) {
        entityManager.persist(music);
    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }

    @Override
    public List<Music> findAll() {
        return entityManager.createQuery("select m from Music m").getResultList();
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
