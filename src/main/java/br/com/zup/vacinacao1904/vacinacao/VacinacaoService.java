package br.com.zup.vacinacao1904.vacinacao;

import br.com.zup.vacinacao1904.usuario.Usuario;
import br.com.zup.vacinacao1904.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class VacinacaoService {

    private final VacinacaoReposity vacinacaoReposity;
    private final UsuarioRepository usuarioRepository;

    public VacinacaoService(VacinacaoReposity vacinacaoReposity, UsuarioRepository usuarioRepository) {
        this.vacinacaoReposity = vacinacaoReposity;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorEmail(String email) {

        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;

    }

    public void salvarVacinacao(VacinacaoRequest request, Usuario usuario) {
        Vacinacao vacinacao = request.toModel(usuario);
        vacinacaoReposity.save(vacinacao);
    }
}
