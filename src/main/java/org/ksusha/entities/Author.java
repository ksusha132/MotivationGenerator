package org.ksusha.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Motivation> motivations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Category_Author> category_authors;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Motivation> getMotivations() {
        return motivations;
    }

    public void setMotivations(Set<Motivation> motivations) {
        this.motivations = motivations;
    }
}
