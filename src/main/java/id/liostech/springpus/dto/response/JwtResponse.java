package id.liostech.springpus.dto.response;

import lombok.Data;

@Data
public class JwtResponse extends UserResponse {
    private String token;
}
