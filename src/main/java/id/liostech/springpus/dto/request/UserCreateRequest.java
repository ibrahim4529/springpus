package id.liostech.springpus.dto.request;

import java.io.Serializable;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public @Data class UserCreateRequest implements Serializable {
    @NotBlank(message = "Nama Tiak boleh kosong")
    private String name;
    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Email tidak valid")
    private String email;
    @NotBlank(message = "Password tidak boleh kosong")
    private String password;
    @NotBlank(message = "User Role tidak boleh kosong")
    private String userRole;
}
