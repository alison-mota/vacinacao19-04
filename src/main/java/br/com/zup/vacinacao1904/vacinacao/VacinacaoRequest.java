package br.com.zup.vacinacao1904.vacinacao;

import br.com.zup.vacinacao1904.usuario.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class VacinacaoRequest {

    @NotBlank
    private String nomeVacina;
    @NotBlank
    @Email
    private String email;

    public String getNomeVacina() {
        return nomeVacina;
    }

    public String getEmail() {
        return email;
    }

    public Vacinacao toModel(Usuario usuario) {
        return new Vacinacao(nomeVacina, usuario);
    }
}
