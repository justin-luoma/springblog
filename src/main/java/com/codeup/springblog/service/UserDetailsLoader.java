package com.codeup.springblog.service;

import com.codeup.springblog.dao.model.User;
import com.codeup.springblog.dao.model.UserWithRoles;
import com.codeup.springblog.dao.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepo userRepo;

    public UserDetailsLoader(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        user = userRepo.findByUsername(username);
//        if (user == null) {
//            user = userRepo.findByEmail(username):
//        }

        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}