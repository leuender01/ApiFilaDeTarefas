package com.prioridade;

public enum Prioridade
{
    FINALIZADA(0),
    BAIXA(1),
    MEDIA(2),
    ALTA(3),
    URGENTE(4);
    private int nivel;
    private Prioridade(int nivel)
    {
        this.nivel = nivel;

    }

    public int getNivel() {
        return nivel;
    }
}
