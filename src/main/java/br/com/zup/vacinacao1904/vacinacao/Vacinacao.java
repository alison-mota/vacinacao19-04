package br.com.zup.vacinacao1904.vacinacao;

import br.com.zup.vacinacao1904.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeVacina;
    @ManyToOne
    private Usuario usuario;
    @Column(updatable = false)
    private LocalDateTime dataAplicacao = LocalDateTime.now();

    @Deprecated
    public Vacinacao(){
    }

    public Vacinacao(String nomeVacina, Usuario usuario) {
        this.nomeVacina = nomeVacina;
        this.usuario = usuario;
    }
}
