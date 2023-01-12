package pfa.iir5.gestion_frais_transport.controllers;

import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import net.bytebuddy.utility.nullability.UnknownNull;
import pfa.iir5.gestion_frais_transport.models.User;
import pfa.iir5.gestion_frais_transport.repositories.UserRepo;

@Controller
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestHeader(HttpHeaders.AUTHORIZATION) String authString) {
        String pair =
                new String(Base64.getDecoder().decode(authString.substring("Basic ".length())));
        String username = pair.split(":")[0];
        String password = pair.split(":")[1];
        User user = userRepo.findByEmail(username).orElseThrow();
        System.out.println(user);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok(userRepo.findByEmail(username).get());
        }
        return ResponseEntity.badRequest().build();
    }
}
