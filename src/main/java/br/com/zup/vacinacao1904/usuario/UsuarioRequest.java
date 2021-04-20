package br.com.zup.vacinacao1904.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Usuario toModel(){
        return new Usuario(nome, email, cpf, dataNascimento);
    }
}
