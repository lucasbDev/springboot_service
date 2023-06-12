package com.RHPback.projeto.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_reuniao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reuniao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReuniao;

    private String moment;

    private String nomereuniao;

    private Integer q_pessoas;

    private String termino_reuniao;

    private String inicio_reuniao;

    @OneToMany
    @JoinTable(
        name = "tb_reuniao_funcionario",
        joinColumns = @JoinColumn(name = "reuniao_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    private Set<Funcionario> convidados = new HashSet<>();

    public Set<Funcionario> getConvidados() {
        return convidados;
    }
}
