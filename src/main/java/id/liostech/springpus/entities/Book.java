package id.liostech.springpus.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
public @Data class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer amount;
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
