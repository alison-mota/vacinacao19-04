package br.com.zup.vacinacao1904.usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean validarEmail(String email) {
        if(usuarioRepository.existsByEmail(email)){
            return true;
        } return false;
    }

    public boolean validarCpf(String cpf) {
        if(usuarioRepository.existsByCpf(cpf)){
            return true;
        } return false;
    }

    public void salvarUsuario(UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioRequest.toModel();
        usuarioRepository.save(usuario);
    }

}


