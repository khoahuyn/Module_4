package test.service;

import test.model.Music;

import java.util.List;

public interface IMusicService {
    void create(Music music);
    void update(Music music);
    Music findById(int id);
    List<Music> findAll();
    void deleteById(int id);
}
