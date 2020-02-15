package steelhacks.covid19.covid19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import steelhacks.covid19.covid19.Entity.Doctor;
import steelhacks.covid19.covid19.Entity.User;
import steelhacks.covid19.covid19.Service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

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

    public List<User> getPatientsByDistance(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        Integer referenceDistance = Integer.parseInt(request.getParameter("distance"));
        Double longitude = Double.parseDouble(request.getParameter("longitude"));
        Double latitude = Double.parseDouble(request.getParameter("latitude"));
        return doctorService.getPatientsByDistance(referenceDistance, longitude, latitude);
    }


}
