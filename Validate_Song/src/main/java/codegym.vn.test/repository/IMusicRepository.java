package codegym.vn.test.repository;




import codegym.vn.test.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music,Integer> {

}
