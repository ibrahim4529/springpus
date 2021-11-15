package id.liostech.springpus.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BookCreateRequest {
    @NotEmpty(message = "Title tidak boleh kosong")
    private String title;
    @NotNull(message = "Amount tidak boleh kosong")
    private Integer amount;
    @NotNull(message = "Author Id tidak boleh kosong")
    private Long authorId;
}
