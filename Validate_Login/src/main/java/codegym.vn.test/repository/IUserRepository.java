package codegym.vn.test.repository;




import codegym.vn.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

}
