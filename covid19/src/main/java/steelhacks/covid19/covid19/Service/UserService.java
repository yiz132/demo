package steelhacks.covid19.covid19.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steelhacks.covid19.covid19.Entity.User;

import java.util.List;


public interface UserService {
    void save(User user);

    boolean checkLogin(String username, String password);

    User findByEmail(String email);

    double getLongitude(String email);

    double getLatitude(String email);

    List<User> getPatientsByDistance(Integer referenceDistance, String email, Double longitude, Double latitude);
}
