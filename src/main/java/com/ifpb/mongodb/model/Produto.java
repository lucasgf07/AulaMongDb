package com.ifpb.mongodb.model;

import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Produto {

    private int codigo;
    private String descricao;
    private float preco;

    public Produto() {
    }

    public Produto(int codigo, String descricao, float preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + Float.floatToIntBits(this.preco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
    
    
    
}
