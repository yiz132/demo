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

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public User doReg(@RequestParam String email, @RequestParam String password,@RequestParam String name,
                      @RequestParam(required = false) Double longitude,
                      @RequestParam(required = false) Double latitude,
                      @RequestParam Integer age, @RequestParam(required = false) Double temperature,
                      @RequestParam(required = false) Integer status) {
        if (userService.findByEmail(email) != null) return null;
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        if (latitude != null)user.setLatitude((latitude));
        if (longitude != null) user.setLongitude(longitude);
        user.setAge(age);
        if (temperature != null) user.setTemperature(temperature);
        if (status != null) user.setStatus(status);
        userService.save(user);
        return user;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public @ResponseBody
    User doLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
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
    public @ResponseBody
    Boolean logout(HttpSession session, HttpServletResponse response) {
        return UserUtil.deleteUserFromSession(session);
    }

   @RequestMapping(path = "/getLongitude", method = RequestMethod.POST)
    public @ResponseBody
   double getLongitude(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        return userService.getLongitude(email);

    }
    @RequestMapping(path = "/getLatitude", method = RequestMethod.POST)
    public @ResponseBody
    double getLatitude(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        return userService.getLatitude(email);
    }

    @PostMapping(path ="/getPatientsInDistance")
    public @ResponseBody
    List<User> getPatientsByDistance(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        Integer referenceDistance = Integer.parseInt(request.getParameter("distance"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        return userService.getPatientsByDistance(referenceDistance, email, longitude, latitude);
    }

    @PostMapping(path = "/submitTemperature")
    public @ResponseBody
    User changeTemperature(@RequestParam String email, @RequestParam int temp){
        User user= userService.findByEmail(email);
        user.setTemperature(temp);
        return user;
    }
}
