package com.finalcit360.booksmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idauthor")
    private int idAuthor;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Author(){}

    public Author(String name, String description){
        this.name = name;
        this.description=description;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
