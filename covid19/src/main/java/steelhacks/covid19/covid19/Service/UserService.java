package steelhacks.covid19.covid19.Service;

import steelhacks.covid19.covid19.Entity.User;
import steelhacks.covid19.covid19.Dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userDao;

    public boolean checkLogin(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username,
                password);
        return user != null;
    }

    public User findByUsernameAndPassword(String username, String password){
        User user = userDao.findByUsernameAndPassword(username, password);
        return user;
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public User findOne(Integer id) {
        return userDao.getOne(id);
    }


}
