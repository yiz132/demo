package steelhacks.covid19.covid19.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import steelhacks.covid19.covid19.Entity.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {

    Doctor findDoctorByEmail(String email);

    Doctor findByEmail(String email);
}
