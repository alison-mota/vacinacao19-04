package br.com.zup.vacinacao1904.vacinacao;

import br.com.zup.vacinacao1904.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/vacinacao")
public class VacinacaoController {

    private final VacinacaoService vacinacaoService;

    public VacinacaoController(VacinacaoService vacinacaoService) {
        this.vacinacaoService = vacinacaoService;
    }


    @PostMapping
    public ResponseEntity<String> novaVacinacao(@Valid @RequestBody VacinacaoRequest request) {

        Usuario usuario = vacinacaoService.novaVacinacao(request.getEmail());

        vacinacaoService.salvaVacinacao(request, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vacinação cadastrada.");

    }
}
