package br.com.reguser.registryuser.modelo;

public enum TipoContato {
    TELEFONE("telefone"),
    EMAIL("email"),
    CELULAR("celular");


    private String descricao;

    TipoContato(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() { return  descricao;};
}
