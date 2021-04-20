package br.com.zup.vacinacao1904.usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
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
