package br.com.reguser.registryuser.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contato {

    @Id
    private Long id;
    private String  valor;
    private TipoContato tipo_contato;

    @ManyToOne
    @JoinColumn(name= "id", nullable = true)
    private User pessoa;

}
