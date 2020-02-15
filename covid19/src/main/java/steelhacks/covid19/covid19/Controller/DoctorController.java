package steelhacks.covid19.covid19.Controller;

import common.ResultBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import steelhacks.covid19.covid19.Entity.Doctor;
import steelhacks.covid19.covid19.Service.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.transform.Result;

@RestController
@RequestMapping(path="/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping(path="/register")
    public @ResponseBody
    Doctor register(@Valid Doctor doctor){
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

}
