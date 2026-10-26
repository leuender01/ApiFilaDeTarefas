package com.prioridade;

public enum Prioridade
{
    BAIXA(0),
    MEDIA(1),
    ALTA(2),
    URGENTE(3);
    private int nivel;
    private Prioridade(int nivel)
    {
        this.nivel = nivel;

    }

    public int getNivel() {
        return nivel;
    }
}
