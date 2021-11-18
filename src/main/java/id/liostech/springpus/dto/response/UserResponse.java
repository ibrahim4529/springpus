package id.liostech.springpus.dto.response;


import id.liostech.springpus.entities.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    private String name;
    private String email;
    private UserRole userRole;
}
