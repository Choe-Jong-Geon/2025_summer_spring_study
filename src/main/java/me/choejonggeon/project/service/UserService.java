package me.choejonggeon.project.service;

import lombok.RequiredArgsConstructor;
import me.choejonggeon.project.Dto.AddUserRequest;
import me.choejonggeon.project.Entity.User;
import me.choejonggeon.project.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    LocalDate expiration = LocalDate.now().plusMonths(6);

    public String save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .id(dto.getId())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .name(dto.getName())
                .expiration(expiration)

                .build()).getId();
    }
}
