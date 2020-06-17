package br.com.exemplospring.exemplo.controller;

import br.com.exemplospring.exemplo.entity.Pessoa;
import br.com.exemplospring.exemplo.repository.PessoaRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // Código de mensagens de retorno do swigger
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @GetMapping(produces = "application/json")
    public List<Pessoa> GetAll(){
        return pessoaRepository.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = "application/json" )
    public ResponseEntity<Pessoa> GetById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(produces = "application/json")
    public Pessoa Post(@RequestBody  @Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> Put(@PathVariable @Valid Long id, @RequestBody Pessoa newPessoa) {
        Optional<Pessoa> oldPessoa =  pessoaRepository.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(value = "/{id}",
    consumes = "application/json")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
