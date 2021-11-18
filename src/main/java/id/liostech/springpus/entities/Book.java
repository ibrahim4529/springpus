package id.liostech.springpus.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
}
