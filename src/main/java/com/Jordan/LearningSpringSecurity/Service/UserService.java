package com.Jordan.LearningSpringSecurity.Service;

import com.Jordan.LearningSpringSecurity.Model.Userinfo;
import com.Jordan.LearningSpringSecurity.Repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final MyUserRepo myUserRepo;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }

    public Userinfo registerUser(Userinfo userinfo) {
        userinfo.setPassword(encoder.encode(userinfo.getPassword()));
        return myUserRepo.save(userinfo);
    }


    public Map<String, String> verify(Userinfo userinfo) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userinfo.getName(), userinfo.getPassword()));

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(userinfo.getName());
            return Map.of("token", token);
        }

        throw new RuntimeException();


    }


}
