package steelhacks.covid19.covid19.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import steelhacks.covid19.covid19.Entity.Doctor;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor, Integer> {
    Doctor findByEmail(String email);
}
