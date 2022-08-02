package br.com.reguser.registryuser.controller;


import br.com.reguser.registryuser.modelo.Contato;
import br.com.reguser.registryuser.modelo.Pessoa;
import br.com.reguser.registryuser.repository.ContatoRepository;
import br.com.reguser.registryuser.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {


    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findPersonById(@PathVariable("id") Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Contato findContactById(@PathVariable("id") Long id){
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{id}")
    public List<Contato> getContacts(@PathVariable Long id){

        Pessoa targetPerson = findPersonById(id);


        return targetPerson.getContatos();

    }

    @PostMapping("/{person_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato createContact(@PathVariable Long person_id, @RequestBody Contato contato){

        Pessoa targetPerson = findPersonById(person_id);


        Contato newContact = contatoRepository.save(contato);
        targetPerson.addContato(newContact);
        pessoaRepository.save(targetPerson);
        System.out.println(newContact);
        return newContact;

    }

    @DeleteMapping("/{contact_id}")
    public void deleteContato(@PathVariable Long contact_id){

        contatoRepository.deleteById(contact_id);

    }
}
