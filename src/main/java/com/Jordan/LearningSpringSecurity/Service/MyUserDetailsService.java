package com.Jordan.LearningSpringSecurity.Service;

import com.Jordan.LearningSpringSecurity.Model.CurrentUserPrincipal;
import com.Jordan.LearningSpringSecurity.Model.Userinfo;
import com.Jordan.LearningSpringSecurity.Repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private final MyUserRepo myUserRepo;

    public MyUserDetailsService(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Userinfo userinfo = myUserRepo.findByName(name);

        if(userinfo==null){
            System.out.println("User Not Found!!!");
            throw new UsernameNotFoundException("User Not Found");
        }

        return new CurrentUserPrincipal(userinfo);
    }
}

