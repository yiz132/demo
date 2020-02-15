package steelhacks.covid19.covid19.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steelhacks.covid19.covid19.Dao.DoctorRepository;
import steelhacks.covid19.covid19.Entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void save(Doctor doctor){
        doctorRepository.save(doctor);
    }

    @Override
    public boolean validate(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor == null) return false;
        return doctor.getPassword().equals(password);
    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }
}
