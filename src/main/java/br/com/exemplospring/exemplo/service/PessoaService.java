package br.com.exemplospring.exemplo.service;

import br.com.exemplospring.exemplo.entity.Pessoa;
import br.com.exemplospring.exemplo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    public PessoaRepository pessoaRepository;

    public void excluir(Long PessoaId) {
        pessoaRepository.deleteById(PessoaId);
    }

}
