package id.liostech.springpus.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public  class AuthorCreateRequest implements Serializable {
    @NotEmpty(message = "Nama Tidak boleh kosong")
    private String name;
}
