package br.com.zup.vacinacao1904.vacinacao;

import br.com.zup.vacinacao1904.usuario.Usuario;
import br.com.zup.vacinacao1904.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/vacinacao")
public class VacinacaoController {

    @Autowired
    private VacinacaoReposity vacinacaoReposity;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> novaVacinacao(@Valid @RequestBody VacinacaoRequest request){
          if(!usuarioRepository.existsByEmail(request.getEmail())){
          return ResponseEntity.status(400).body("Usuário não cadastrado.");
      }
          Usuario usuario = usuarioRepository.findByEmail(request.getEmail());
          Vacinacao vacinacao = request.toModel(usuario);
          vacinacaoReposity.save(vacinacao);

          return ResponseEntity.status(201).body("Vacinação cadastrada para o usuário " + usuario.getNome() + ".");
}
}
