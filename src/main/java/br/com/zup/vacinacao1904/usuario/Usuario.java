package br.com.zup.vacinacao1904.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Column(unique = true)
    @Email
    @NotBlank
    private String email;
    @Column(unique = true)
    @CPF
    @NotBlank
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    @Deprecated
    public Usuario(){

    }

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
}
