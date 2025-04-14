package com.alura.conversormonedas.modelos;

public class Moneda {
    private String codigo;
    private Double valor;

    public Moneda( String codigo,Double valor) {
        this.valor = valor;
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo + ":" + valor;
    }
}
