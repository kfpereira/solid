package com.solid.srp;

import java.math.BigDecimal;

public class Item {

    private String descricao;
    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isSame(Item item) {
        return this.getDescricao().equals(item.getDescricao()) && this.getValor().equals(item.getValor());
    }
}
