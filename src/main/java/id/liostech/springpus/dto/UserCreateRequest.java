package id.liostech.springpus.dto;

import java.io.Serializable;

import lombok.Data;

public @Data class UserCreateRequest implements Serializable {
    private String name;
    private String email;
    private String password;
}
