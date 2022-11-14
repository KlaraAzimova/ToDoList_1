package com.mapper;

import com.domain.User;
import com.dto.UserDto;
import com.dto.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder encoder;

    @Autowired
    public UserMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public User mapToUser(RegisterForm registerForm) {
        return User.builder()
                .username(registerForm.getUsername())
                .email(registerForm.getEmail())
                .password(encoder.encode(registerForm.getPassword()))
                .enabled(true)
                .build();
    }

    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
