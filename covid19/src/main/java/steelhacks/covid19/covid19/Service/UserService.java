package steelhacks.covid19.covid19.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steelhacks.covid19.covid19.Entity.User;


public interface UserService {
    void save(User user);

    boolean checkLogin(String username, String password);

    User findByUsernameAndPassword(String username, String password);

    double getLongitude(String email);

    double getLatitude(String email);

    Integer getPatientsByDistance(Integer referenceDistance, String email, Double longitude, Double latitude);
}
