package id.liostech.springpus.services.impl;

import id.liostech.springpus.entities.User;
import id.liostech.springpus.dto.request.UserCreateRequest;
import id.liostech.springpus.repositories.UserRepository;
import id.liostech.springpus.services.UserService;
import id.liostech.springpus.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ValidationUtil validationUtil;

    @Override
    public User create(UserCreateRequest createRequest) {
        validationUtil.validate(createRequest);
        User user = modelMapper.map(createRequest, User.class);
        return userRepository.save(user);
    }

    @Override
    public User registerUser(UserCreateRequest createRequest) {
        validationUtil.validate(createRequest);
        boolean userExists = userRepository.findByEmail(createRequest.getEmail()).isPresent();
        if(userExists){
            throw new RuntimeException(
                    String.format("User dengan email '%s' telah terdaftar", createRequest.getEmail())
            );
        }
        User user = modelMapper.map(createRequest, User.class);
        String encodedPassword = bCryptPasswordEncoder.encode(createRequest.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User dengan email '%s' tidak ada", email)));
    }
}
