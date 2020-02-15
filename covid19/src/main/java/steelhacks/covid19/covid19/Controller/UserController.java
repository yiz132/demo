package steelhacks.covid19.covid19.Controller;

import com.google.api.Http;
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
import javax.swing.text.html.StyleSheet;
import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResultBase doReg(@Valid User user) {
        userService.save(user);
        ResultBase rs=new ResultBase();
        rs.setToSuccess();
        return rs;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User doLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if (userService.checkLogin(username,password)) {
            User user = userService.findByUsernameAndPassword(username, password);
            UserUtil.saveUserToSession(session, user);
            return user;
        }
        return null;

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Boolean logout(HttpSession session, HttpServletResponse response) {
        return UserUtil.deleteUserFromSession(session);
    }

   @RequestMapping(value = "/getLocation", method = RequestMethod.POST)
    public double getLongitude(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        return userService.getLongitude(email);

    }
    @RequestMapping(value = "/getLocation", method = RequestMethod.POST)
    public double getLatitude(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        return userService.getLatitude(email);

    }
    @RequestMapping(value = "/getLocation", method = RequestMethod.POST)

    public Integer getPatientsByDistance(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        Integer referenceDistance = Integer.parseInt(request.getParameter("distance"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        return userService.getPatientsByDistance(referenceDistance, email, longitude, latitude);
    }
}
