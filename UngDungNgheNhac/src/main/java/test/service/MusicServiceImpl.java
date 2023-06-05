package test.service;

import org.springframework.stereotype.Service;
import test.model.Music;
import test.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    IMusicRepository repository;
    @Override
    public void create(Music music) {
        repository.create(music);
    }

    @Override
    public void update(Music music) {
        repository.update(music);
    }

    @Override
    public Music findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Music> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
