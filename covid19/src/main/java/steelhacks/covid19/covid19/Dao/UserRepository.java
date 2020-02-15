package steelhacks.covid19.covid19.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import steelhacks.covid19.covid19.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);


    @Query(value="SELECT * FROM Users", nativeQuery = true)
    List<User> findAllUser();
}
