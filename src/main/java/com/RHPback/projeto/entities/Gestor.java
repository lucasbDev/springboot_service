package com.RHPback.projeto.entities;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_Gestor")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor


public class Gestor implements Serializable {
	private static final long serialVersionUID = 1L;

	////////////// ATRIBUTOS////////////////////////
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGestor;

	@Column(nullable = false, name = "nome", length = 50)
	private String nome;

	@Column(nullable = false, unique = true, name = "email", length = 50)
	private String email;

	@Column(name = "senha", length = 50)
	private String senha;
	
	

}



	
	
	


