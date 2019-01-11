package com.renevoi.springsecurity.springsecuritydb.service;

import com.renevoi.springsecurity.springsecuritydb.model.CustomUserDetails;
import com.renevoi.springsecurity.springsecuritydb.model.Users;
import com.renevoi.springsecurity.springsecuritydb.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByName(username);
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new)
                .get();
        /*return optionalUsers
                .map(users -> new CustomUserDetails(users))
                .get();*/
        /*CustomUserDetails customUserDetails = optionalUsers
                .map(users -> new CustomUserDetails(users))
                .get();
        return customUserDetails;*/
    }
}
