package steelhacks.covid19.covid19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import steelhacks.covid19.covid19.Entity.Doctor;
import steelhacks.covid19.covid19.Entity.User;
import steelhacks.covid19.covid19.Service.DoctorService;
import steelhacks.covid19.covid19.Service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @PostMapping(path="/register")
    public @ResponseBody
    Doctor register(@RequestParam String email, @RequestParam String password){
        Doctor doctor = new Doctor();
        doctor.setEmail(email);
        doctor.setPassword(password);

        doctorService.save(doctor);
        return doctor;
    }

    @PostMapping(path="/login")
    public @ResponseBody
    Doctor login(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (! doctorService.validate(email,password)) return null;
        return doctorService.findDoctorByEmail(email);
    }

    @RequestMapping(path="/aggregation/byDistance")
    public List<User> getPatientsByDistance(@RequestParam String email,@RequestParam Integer distance) {
        return userService.getPatientsByDistance(email, distance);
    }

    @RequestMapping(path="/aggregation/byAge")
    public List<User> getPatientsByAge(@RequestParam Integer from, @RequestParam Integer to) {
        return userService.findPatientsInRang(from, to);
    }

}
