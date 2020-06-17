package br.com.exemplospring.exemplo.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Pessoa {

    @ApiModelProperty(value = "Código da pessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome da Pessoa")
    @Column(nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
