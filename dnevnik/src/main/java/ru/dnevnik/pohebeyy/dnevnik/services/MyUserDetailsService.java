package ru.dnevnik.pohebeyy.dnevnik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.dnevnik.pohebeyy.dnevnik.config.MyUserDetails;
import ru.dnevnik.pohebeyy.dnevnik.models.MyUser;
import ru.dnevnik.pohebeyy.dnevnik.repositiry.UserRepository;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = repository.findByName(username);
        return user.map(MyUserDetails:: new)
                .orElseThrow(()->new UsernameNotFoundException(username+"not found"));

    }
}
