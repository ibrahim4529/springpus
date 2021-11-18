package id.liostech.springpus.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class AuthLoginRequest {
    @NotBlank(message = "Email tidak boleh kosong")
    private String email;
    @NotBlank(message = "Password tidak boleh kosong")
    private String password;
}
