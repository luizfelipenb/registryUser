package br.com.reguser.registryuser.modelo;




import javax.persistence.*;

@Entity
public class Contato {

    @Id
    private Long id;

    @Column(name = "VALOR")
    private String  valor;

    @Column(name = "TIPO_CONTATO")
    private String tipo_contato;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PESSOA_ID" ,nullable = true)
    private Pessoa pessoa;

}
