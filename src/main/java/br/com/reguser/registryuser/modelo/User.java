package br.com.reguser.registryuser.modelo;

import javax.persistence.Id;

public class User {

    @Id
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String data_nascimento;

}
