package steelhacks.covid19.covid19.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steelhacks.covid19.covid19.Entity.Doctor;


public interface DoctorService {
    void save(Doctor doctor);

    boolean validate(String email, String password);

    Doctor findDoctorByEmail(String email);
}
