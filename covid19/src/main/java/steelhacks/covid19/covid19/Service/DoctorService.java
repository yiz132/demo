package steelhacks.covid19.covid19.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steelhacks.covid19.covid19.Entity.Doctor;
import steelhacks.covid19.covid19.Entity.User;

import java.util.List;


public interface DoctorService {

    List<User> getPatientsByDistance(Integer referenceDistance, Double longitude, Double latitude);

    void save(Doctor doctor);

    boolean validate(String email, String password);

    Doctor findDoctorByEmail(String email);
}
