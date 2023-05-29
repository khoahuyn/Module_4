package codegym.vn.service;

import codegym.vn.model.Declaration;
import codegym.vn.repository.DeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationServiceImpl implements DeclarationService {

    @Autowired
    DeclarationRepository repository;

    @Override
    public List<Declaration> findAll() {
        return repository.findAll();
    }

    @Override
    public List<String> yearOfBirthList() {
        return repository.yearOfBirthList();
    }

    @Override
    public List<String> genderList() {
        return repository.genderList();
    }

    @Override
    public List<String> nationalityList() {
        return repository.nationalityList();
    }

    @Override
    public List<String> vehicleList() {
        return repository.vehicleList();
    }

    @Override
    public void create(Declaration declaration) {
        repository.create(declaration);
    }

    @Override
    public boolean update(Declaration declaration) {
        return repository.update(declaration);
    }

    @Override
    public Declaration findByIdentifyCard(String ICard) {
        return repository.findByIdentifyCard(ICard);
    }
}
