package id.liostech.springpus.models;

import lombok.Data;

import java.io.Serializable;

@Data
public  class AuthorCreateRequest implements Serializable {
    private String name;
}
