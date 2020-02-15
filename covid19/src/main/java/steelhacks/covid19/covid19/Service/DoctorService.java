package steelhacks.covid19.covid19.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import steelhacks.covid19.covid19.Dao.DoctorRepository;
import steelhacks.covid19.covid19.Entity.Doctor;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public boolean validate(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor == null) return false;
        return doctor.getPassword().equals(password);
    }

    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }
}
