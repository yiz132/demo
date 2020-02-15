package steelhacks.covid19.covid19.Service;

import steelhacks.covid19.covid19.Dao.UserRepository;
import steelhacks.covid19.covid19.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;

    @Transactional
    public boolean checkLogin(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username,
                password);
        return user != null;
    }


    @Transactional
    public User findByUsernameAndPassword(String username, String password){
        User user = userDao.findByUsernameAndPassword(username, password);
        return user;
    }


    @Transactional
    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }


    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public User findOne(Integer id) {
        return userDao.getOne(id);
    }

    @Transactional
    public double getLongitude(String email) {
        return userDao.findByEmail(email).getLongitude();


    }

    @Transactional
    public double getLatitude(String email) {
        return userDao.findByEmail(email).getLatitude();
    }


    @Transactional
    public Integer getPatientsByDistance(Integer referenceDistance, String email, Double longitude, Double latitude) {
        Integer i = 0;
        for(User user: userDao.find()){
            if(user.getEmail().equals(email)) continue;
            if(getDistance(longitude, latitude, user.getLongitude(), user.getLatitude()) <= referenceDistance) i++;
        }
        return i;
    }

    @Transactional
    public  Double getDistance(Double standardLongitude, Double standardLatitude, Double longitude, Double latitude){
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

}
