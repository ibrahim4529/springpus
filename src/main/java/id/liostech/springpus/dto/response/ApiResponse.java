package id.liostech.springpus.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiResponse {
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private Object data;

    public boolean isStatus() {
        return status;
    }
}
