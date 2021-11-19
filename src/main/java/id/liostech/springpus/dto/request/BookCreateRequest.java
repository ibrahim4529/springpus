package id.liostech.springpus.dto.request;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class BookCreateRequest {
    @NotEmpty(message = "Title tidak boleh kosong")
    private String title;
    @NotNull(message = "Amount tidak boleh kosong")
    private Integer amount;
    @NotNull(message = "Author Id tidak boleh kosong")
    private Long authorId;

    private MultipartFile image;
}
