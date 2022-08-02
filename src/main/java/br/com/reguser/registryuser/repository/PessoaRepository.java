package br.com.reguser.registryuser.repository;

import br.com.reguser.registryuser.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
