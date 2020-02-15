package steelhacks.covid19.covid19.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import steelhacks.covid19.covid19.Entity.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {

    Doctor findByEmail(String email);
}
