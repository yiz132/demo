package steelhacks.covid19.covid19.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import steelhacks.covid19.covid19.Dao.DoctorDao;
import steelhacks.covid19.covid19.Entity.Doctor;

@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    public void save(Doctor doctor){
        doctorDao.save(doctor);
    }

    public boolean validate(String email, String password) {
        Doctor doctor = doctorDao.findByEmail(email);
        if (doctor == null) return false;
        return doctor.getPassword().equals(password);
    }

    public Doctor findDoctorByEmail(String email) {
        return doctorDao.findDoctorByEmail(email);
    }
}
