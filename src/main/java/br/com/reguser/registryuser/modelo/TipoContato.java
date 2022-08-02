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

    public static TipoContato fromString(String descricao) {
        for (TipoContato type : TipoContato.values()) {
            if (type.descricao.equalsIgnoreCase(descricao)) {
                return type;
            }
        }
        return null;
    }
}
