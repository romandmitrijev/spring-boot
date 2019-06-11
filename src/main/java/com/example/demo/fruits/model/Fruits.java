package com.example.demo.fruits.model;


import javax.persistence.*;

@Entity
public class Fruits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="description_f")
    private String descriptionF;

    public Fruits() {
    }

    public Fruits(Long id, String name, String descriptionF) {
        this.id = id;
        this.name = name;
        this.descriptionF = descriptionF;
    }

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

    public String getDescriptionF() {
        return descriptionF;
    }

    public void setDescriptionF(String descriptionF) {
        this.descriptionF = descriptionF;
    }
}
