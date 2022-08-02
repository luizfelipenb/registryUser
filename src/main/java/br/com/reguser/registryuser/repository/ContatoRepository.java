package br.com.reguser.registryuser.repository;

import br.com.reguser.registryuser.modelo.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
