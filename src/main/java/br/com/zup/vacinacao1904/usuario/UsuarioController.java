package br.com.zup.vacinacao1904.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<ResponseEntity> novoUsuario(@Valid @RequestBody UsuarioRequest request) {
        if(usuarioService.validarEmail(request.getEmail())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (usuarioService.validarCpf(request.getCpf())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        usuarioService.salvarUsuario(request);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}