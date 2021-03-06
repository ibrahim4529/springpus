package id.liostech.springpus.services;

import id.liostech.springpus.entities.User;
import id.liostech.springpus.dto.request.UserCreateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;

@Transactional
public interface UserService extends UserDetailsService {
    User create(UserCreateRequest createRequest);
    User registerUser(UserCreateRequest createRequest);
}
