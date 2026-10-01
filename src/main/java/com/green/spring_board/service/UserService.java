package com.green.spring_board.service;

import com.green.spring_board.dto.SignupRequest;
import com.green.spring_board.entity.User;
import com.green.spring_board.exceptions.ResourceConflictException;
import com.green.spring_board.exceptions.UserRequestException;
import com.green.spring_board.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void signup(SignupRequest signupRequest) {
        if (signupRequest.getEmail().isBlank() || signupRequest.getPassword().isEmpty()) {
            throw new UserRequestException("이메일이나 비밀번호를 입력하지 않음.");
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new ResourceConflictException("이미 사용중인 이메일입니다.");
        }

        String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
        User user = new User();
        user.setNickname(signupRequest.getNickname());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
