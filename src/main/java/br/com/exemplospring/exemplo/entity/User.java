package br.com.exemplospring.exemplo.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class User {

    @ApiModelProperty(value = "Código do Usuario")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome do Usuario")
    @Column(nullable = false)
    private String name;

    @ApiModelProperty(value = "Email do Usuario")
    @Column(nullable = false)
    private String email;

    public User() {

    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
