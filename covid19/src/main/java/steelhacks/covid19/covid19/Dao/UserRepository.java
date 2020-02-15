package steelhacks.covid19.covid19.Dao;

import steelhacks.covid19.covid19.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);

    public User  findByUsername(String username);
}