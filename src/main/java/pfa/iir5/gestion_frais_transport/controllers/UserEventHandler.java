package pfa.iir5.gestion_frais_transport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pfa.iir5.gestion_frais_transport.models.User;
import pfa.iir5.gestion_frais_transport.repositories.UserRepo;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepository;

    @HandleBeforeCreate
    public void handleUserCreate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @HandleBeforeSave
    public void handleUserUpdate(User user) {
        if (user.getPassword() == null || user.getPassword().equals("")) {
            // keeps the last password
            User storedUser = userRepository.getOne(user.getId());
            user.setPassword(storedUser.getPassword());
        } else {
            // password change request
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
    }
}
