package com.farmermanagimentsystem.Service;

import com.farmermanagimentsystem.Repository.Modal.Login;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }

    public boolean validateLogin(String username, String password) {
        Login user = findByUsername(username);

        // Check if the user exists and the password matches
        return user != null && user.getPassword().equals(password);
    }
}
