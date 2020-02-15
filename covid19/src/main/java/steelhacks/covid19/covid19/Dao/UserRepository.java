package steelhacks.covid19.covid19.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import steelhacks.covid19.covid19.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);

    public User findByEmail(String username);
    public User getOne(Integer id);
    public List<User> find();
}