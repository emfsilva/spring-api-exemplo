package br.com.exemplospring.exemplo.repository;

import br.com.exemplospring.exemplo.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
