package steelhacks.covid19.covid19.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import steelhacks.covid19.covid19.Entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

    Doctor findByEmail(String email);
}
