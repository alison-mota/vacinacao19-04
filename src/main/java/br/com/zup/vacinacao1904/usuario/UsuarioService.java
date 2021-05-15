package br.com.zup.vacinacao1904.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validaUsuario(UsuarioRequest request) {

        if (usuarioRepository.existsByCpf(request.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um usuário cadastrado com esse CPF.");
        } else if (usuarioRepository.existsByEmail(request.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um usuário cadastrado com esse e-mail.");
        }
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}


