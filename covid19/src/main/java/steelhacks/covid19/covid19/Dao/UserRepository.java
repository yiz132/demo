package steelhacks.covid19.covid19.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import steelhacks.covid19.covid19.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);

    User findByEmail(String email);

    User getOne(Integer id);

    List<User> find();
}
