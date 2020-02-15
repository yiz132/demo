package steelhacks.covid19.covid19.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steelhacks.covid19.covid19.Dao.DoctorRepository;
import steelhacks.covid19.covid19.Entity.Doctor;
import steelhacks.covid19.covid19.Entity.User;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<User> getPatientsByDistance(Integer referenceDistance, Double longitude, Double latitude) {
        List<User> users = 
        return doctorRepository.getPatientsInRange();
    }

    public Double getDistance(Double standardLongitude, Double standardLatitude, Double longitude, Double latitude){
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(standardLatitude);
        double lon1 = Math.toRadians(standardLongitude);
        double lat2 = Math.toRadians(latitude);
        double lon2 = Math.toRadians(longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);
        return STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
    }

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
