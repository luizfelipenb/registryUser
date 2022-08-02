package br.com.reguser.registryuser.controller;

import br.com.reguser.registryuser.modelo.Pessoa;
import br.com.reguser.registryuser.repository.PessoaRepository;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;




@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findById(@PathVariable("id") Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Pessoa> listPerson(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa createPerson(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
        return pessoa;
    }


    @PutMapping("/{id}")
    public Pessoa updatePerson(@PathVariable("id") Long id,  @RequestBody Pessoa pessoa)
     {
        Pessoa targetPerson = findById(id);

       BeanUtils.copyProperties(pessoa, targetPerson, "id");

        return pessoaRepository.save(targetPerson);


    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id){
        pessoaRepository.deleteById(id);

        return "Pessoa deletada com sucesso";
    }

    @GetMapping("/{id}")
    public Pessoa getPersonById(@PathVariable Long id){
        Pessoa targetPerson =   findById(id);

        return targetPerson;
    }
}
