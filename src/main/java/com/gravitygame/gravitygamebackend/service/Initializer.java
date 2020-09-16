package com.gravitygame.gravitygamebackend.service;

import com.gravitygame.gravitygamebackend.entity.CustomUser;
import com.gravitygame.gravitygamebackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("production")
public class Initializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public Initializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
/*        userRepository.save(CustomUser.builder()
                .username("aaa")
                .password("12345")
                .roles(Arrays.asList("USER"))
                .build());*/

        userRepository.save(new CustomUser("aaa","123"));
        userRepository.save(new CustomUser("bbb","123"));
        userRepository.save(new CustomUser("ccc","123"));
        userRepository.save(new CustomUser("ddd","123"));


    }
}
