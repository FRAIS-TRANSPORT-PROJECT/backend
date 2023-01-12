package pfa.iir5.gestion_frais_transport.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pfa.iir5.gestion_frais_transport.models.User.Role;
import pfa.iir5.gestion_frais_transport.services.UsersSvc;

@Configuration
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// @EnableWebSecurity
public class SecurityConfig {
        @Autowired
        private UsersSvc usersSvc;
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
                authProvider.setUserDetailsService(usersSvc);
                authProvider.setPasswordEncoder(passwordEncoder);
                return authProvider;
        }


        // @Autowired
        // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.authenticationProvider(authenticationProvider());
        // }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeRequests().antMatchers("/api/v1", "/login").permitAll();

                http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/api/v1/**").permitAll();

                http.authorizeRequests().antMatchers("/api/v1/users/**").hasAnyAuthority(
                                Role.ROLE_ADMIN.toString(), Role.ROLE_MANAGER.toString());

                http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/demandes/**")
                                .hasAnyAuthority(Role.ROLE_DEMANDEUR.toString(),
                                                Role.ROLE_MANAGER.toString());

                http.authorizeRequests()
                                .antMatchers(HttpMethod.POST, "/api/v1/demandes/**",
                                                "/api/v1/documents/**")
                                // .hasAnyAuthority(Role.ROLE_DEMANDEUR.toString());
                                .permitAll();

                http.authorizeRequests()
                                .antMatchers(HttpMethod.PUT, "/api/v1/demandes/**",
                                                "/api/v1/documents/**")
                                .hasAnyAuthority(Role.ROLE_DEMANDEUR.toString());

                http.authorizeRequests()
                                .antMatchers(HttpMethod.PUT, "/api/v1/demandes/**",
                                                "/api/v1/documents/**")
                                .hasAnyAuthority(Role.ROLE_DEMANDEUR.toString());

                http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/api/v1/demandes/**")
                                .hasAnyAuthority(Role.ROLE_DEMANDEUR.toString(),
                                                Role.ROLE_MANAGER.toString());

                http.authorizeRequests().antMatchers("/api/v1/demandeurs/**", "/api/v1/managers/**")
                                .hasAnyAuthority(Role.ROLE_ADMIN.toString());

                http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf()
                                .disable();

                return http.build();

        }

}

