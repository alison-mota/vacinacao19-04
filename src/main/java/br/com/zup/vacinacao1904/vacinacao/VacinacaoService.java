package br.com.zup.vacinacao1904.vacinacao;

import br.com.zup.vacinacao1904.usuario.Usuario;
import br.com.zup.vacinacao1904.usuario.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VacinacaoService {

    private final VacinacaoReposity vacinacaoReposity;
    private final UsuarioRepository usuarioRepository;

    public VacinacaoService(VacinacaoReposity vacinacaoReposity, UsuarioRepository usuarioRepository) {
        this.vacinacaoReposity = vacinacaoReposity;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario novaVacinacao(String email) {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
        return usuario;
    }

    public void salvaVacinacao(VacinacaoRequest request, Usuario usuario) {
        Vacinacao vacinacao = request.toModel(usuario);
        vacinacaoReposity.save(vacinacao);
    }


}
