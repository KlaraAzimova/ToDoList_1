package com.api;

import com.dto.form.RegisterForm;
import com.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainApi {

    private final MainService mainService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm registerForm) {
        return mainService.register(registerForm);
    }
}
