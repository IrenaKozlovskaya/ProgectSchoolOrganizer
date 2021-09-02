package com.myapp.security.jwt;

import com.myapp.model.User;
import com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;


    @Autowired
    public JwtUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.getUser(email);
        if(user==null){
            throw new UsernameNotFoundException("User with email "+ email +" not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
