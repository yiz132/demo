package steelhacks.covid19.covid19.Dao;

import org.springframework.data.jpa.repository.Query;
import steelhacks.covid19.covid19.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);

    public User  findByUsername(String username);

    public User countAgeRange(Integer age_min, Integer age_max);
}
