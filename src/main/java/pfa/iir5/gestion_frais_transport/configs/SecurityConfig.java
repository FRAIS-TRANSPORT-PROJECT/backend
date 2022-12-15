package pfa.iir5.gestion_frais_transport.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests().antMatchers(Constants.API_PREFIX +
        // "/devs/**").hasRole(Constants.getRole("dev"));
        // http.authorizeHttpRequests().antMatchers(Constants.API_PREFIX +
        // "/admins/**").hasRole(Constants.getRole("admin"));
        // http.authorizeHttpRequests().antMatchers(Constants.API_PREFIX +
        // "/clients/**").hasRole(Constants.getRole("client"));
        // http.authorizeRequests().anyRequest().authenticated();
        // http.httpBasic();
        http.cors().and().csrf().disable();
        http.authorizeHttpRequests().anyRequest().permitAll();

    }
}
