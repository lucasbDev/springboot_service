package com.RHPback.projeto.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @Column(nullable = false, name = "nome", length = 50)
    private String nome;

    @Column(nullable = false, unique = true, name = "email", length = 50)
    private String email;

    @Column(name = "senha", length = 50)
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "convidados")
    private Set<Reuniao> reunioes = new HashSet<>();

    public Set<Reuniao> getReunioes() {
        return reunioes;
    }
}
