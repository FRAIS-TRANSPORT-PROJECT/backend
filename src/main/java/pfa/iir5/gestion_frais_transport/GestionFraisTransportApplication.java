package pfa.iir5.gestion_frais_transport;

import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pfa.iir5.gestion_frais_transport.models.User;
import pfa.iir5.gestion_frais_transport.models.User.Role;
import pfa.iir5.gestion_frais_transport.repositories.UserRepo;

@SpringBootApplication
public class GestionFraisTransportApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionFraisTransportApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

	@Autowired
	UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder().encode("admin"));
		System.out.println(passwordEncoder().encode("admin"));
		// userRepo.save(User.builder().email("test").firstName("").lastName("null")
		// .password(passwordEncoder().encode("test")).role(Role.ROLE_ADMIN).matricule("fdsqf")
		// .build());

	}

}
