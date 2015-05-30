package tk.altoscodigos.fragments;

import java.io.Serializable;

public class DadosDoItem implements Serializable{

    private Integer codigo;
    private String descricao;

    public DadosDoItem( Integer codigo, String descricao ) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
