package br.com.zup.vacinacao1904.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> novoUsuario(@Valid @RequestBody UsuarioRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(400).body("Este e-mail já está cadastrado em outro usuário.");

        } else if (usuarioRepository.existsByCpf(request.getCpf())) {
            return ResponseEntity.status(400).body("Este CPF já está cadastrado em outro usuário.");
        }

        Usuario usuario = request.toModel();
        usuarioRepository.save(usuario);

        return ResponseEntity.status(201).body("O usuário " + usuario.getNome() + " foi cadastrado.");

    }
}