package id.liostech.springpus.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthLoginRequest {
    private String email;
    private String password;
}
