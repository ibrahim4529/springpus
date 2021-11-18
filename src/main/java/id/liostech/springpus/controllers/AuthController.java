package id.liostech.springpus.controllers;

import id.liostech.springpus.dto.response.ApiResponse;
import id.liostech.springpus.dto.response.JwtResponse;
import id.liostech.springpus.dto.response.UserResponse;
import id.liostech.springpus.dto.request.AuthLoginRequest;
import id.liostech.springpus.dto.request.UserCreateRequest;
import id.liostech.springpus.entities.User;
import id.liostech.springpus.services.UserService;
import id.liostech.springpus.utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthLoginRequest authLoginRequest, Errors errors) {
        ApiResponse response = new ApiResponse();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authLoginRequest.getEmail(), authLoginRequest.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = jwtUtil.generateToken(user);
        JwtResponse jwtResponse = modelMapper.map(user, JwtResponse.class);
        jwtResponse.setToken(token);
        response.setData(jwtResponse);
        response.setStatus(true);
        response.getMessages().add("Login Berhasil");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCreateRequest userCreateRequest) {
        ApiResponse response = new ApiResponse();
        User user = userService.registerUser(userCreateRequest);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        response.setData(userResponse);
        response.setStatus(true);
        response.getMessages().add("Register Berhasil");
        return ResponseEntity.ok(response);
    }
}
