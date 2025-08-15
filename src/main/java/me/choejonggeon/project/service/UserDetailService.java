package me.choejonggeon.project.service;

import lombok.RequiredArgsConstructor;
import me.choejonggeon.project.Entity.User;
import me.choejonggeon.project.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
//스프링 시큐리티에서 사용자 정보를 가져오는 클래스
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

    }
}
