package codegym.vn.repository;

import codegym.vn.model.Declaration;

import java.util.List;

public interface DeclarationRepository {
    List<Declaration> findAll();

    List<String> yearOfBirthList();

    List<String> genderList();

    List<String> nationalityList();

    List<String> vehicleList();

    void create(Declaration declaration);

    boolean update(Declaration declaration);

    Declaration findByIdentifyCard(String ICard);
}
