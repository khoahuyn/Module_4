package codegym.vn.test.service;

import codegym.vn.test.model.Music;
import codegym.vn.test.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    IMusicRepository repository;
    @Override
    public void create(Music music) {
        repository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return (List<Music>) repository.findAll();
    }

    @Override
    public void update(Music music) {
        if(repository.existsById(music.getId())){
            repository.save(music);
        }
    }

    @Override
    public Music findById(int id) {
        return repository.findById(id).orElse(null);
    }


}
