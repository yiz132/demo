package steelhacks.covid19.covid19.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import steelhacks.covid19.covid19.Entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends DoctorRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);

    public User  findByUsername(String username);
    public User getOne(Integer id);
}
