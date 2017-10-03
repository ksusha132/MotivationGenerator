package org.ksusha.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "motivation")
public class Motivation {
    public Motivation() {
    }

    public Motivation(String body) {
        this.body = body;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "body", nullable = false, insertable = true, updatable = true, length = 255)
    private String body;

    @ManyToOne()
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private Author author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "motivation", cascade = CascadeType.ALL)
    private Set<Motivation_Category> motivation_categories;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
