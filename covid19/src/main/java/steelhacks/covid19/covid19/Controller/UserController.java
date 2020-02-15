package steelhacks.covid19.covid19.Controller;

import common.ResultBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import steelhacks.covid19.covid19.Entity.User;
import steelhacks.covid19.covid19.Service.UserService;
import steelhacks.covid19.covid19.Utils.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public User doReg(@Valid User user) {
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

    public Integer getPatientsByDistance(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        Integer referenceDistance = Integer.parseInt(request.getParameter("distance"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        return userService.getPatientsByDistance(referenceDistance, email, longitude, latitude);
    }
}
