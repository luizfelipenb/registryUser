package br.com.reguser.registryuser.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private String data_nascimento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Contato> contatos;


    public void addContato(Contato contato){
        contatos.add(contato);
    }

}
