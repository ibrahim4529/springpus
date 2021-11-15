package id.liostech.springpus.dto;

import lombok.Data;

@Data
public class BookCreateRequest {
    private String title;
    private Integer amount;
}
