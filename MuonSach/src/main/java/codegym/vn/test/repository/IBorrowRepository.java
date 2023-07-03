package codegym.vn.test.repository;


import codegym.vn.test.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow,Integer> {
}
