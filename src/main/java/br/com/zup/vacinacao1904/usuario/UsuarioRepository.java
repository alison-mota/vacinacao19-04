package br.com.zup.vacinacao1904.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    Usuario findByEmail(String email);
}
