package com.gravitygame.gravitygamebackend.security;

import com.gravitygame.gravitygamebackend.entity.CustomUser;
import com.gravitygame.gravitygamebackend.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username" + username + "Not found"));
        return new User(customUser.getUsername(),customUser.getPassword(),
                customUser.getRoles().stream().map(SimpleGrantedAuthority::new)
                                                .collect(Collectors.toList()));
    }
}
