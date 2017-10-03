package org.ksusha.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    public Category() {
    }

    public Category(String body) {
        this.body = body;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false, insertable = true, updatable = true, length = 20)
    private String body;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Motivation_Category> motivation_categories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Category_Author> category_authors;




    public Set<Category_Author> getCategory_authors() {
        return category_authors;
    }

    public void setCategory_authors(Set<Category_Author> category_authors) {
        this.category_authors = category_authors;
    }

    public Set<Motivation_Category> getMotivation_categories() {
        return motivation_categories;
    }

    public void setMotivation_categories(Set<Motivation_Category> motivation_categories) {
        this.motivation_categories = motivation_categories;
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
