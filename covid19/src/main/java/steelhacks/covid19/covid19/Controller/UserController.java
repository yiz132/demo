package steelhacks.covid19.covid19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import steelhacks.covid19.covid19.Entity.User;
import steelhacks.covid19.covid19.Service.UserService;
import steelhacks.covid19.covid19.Utils.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public User doReg(@RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);
        return user;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User doLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if (userService.checkLogin(username,password)) {
            User user = userService.findByEmail(username);
            UserUtil.saveUserToSession(session, user);
            return user;
        }
        return null;

    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public Boolean logout(HttpSession session, HttpServletResponse response) {
        return UserUtil.deleteUserFromSession(session);
    }

   @RequestMapping(path = "/getLongitude", method = RequestMethod.POST)
    public double getLongitude(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        return userService.getLongitude(email);

    }
    @RequestMapping(path = "/getLatitude", method = RequestMethod.POST)
    public double getLatitude(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        return userService.getLatitude(email);
    }

    @RequestMapping(path="/aggregation/byDistance")
    public List<User> getPatientsByDistance(@RequestParam String email,@RequestParam Integer distance) {
        return userService.getPatientsByDistance(email, distance);
    }
}
