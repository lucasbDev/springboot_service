package com.RHPback.projeto.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_evento")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "local", length = 50)
    @NotNull
    private String local;


    @Column(name = "data", length = 10)
    @NotNull
    private String data;

    @Column(name = "horarioInicio", length = 10)
    @NotNull
    private String horarioInicio;

    @Column(name = "horarioFinal", length = 10)
    @NotNull
    private String horarioFinal;
    

    @Column(name = "quantidade", length = 5)
    private String quantidade;


    @Column(name = "email")
    private String email;

   

   
    @ManyToMany
    @JoinTable(name = "evento_funcionario",
        joinColumns = @JoinColumn(name = "reuniao_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> inscritos= new ArrayList<>();


}