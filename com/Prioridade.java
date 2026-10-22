package com;

public enum Prioridade
{
    BAIXA(4),
    MEDIA(3),
    ALTA(2),
    URGENTE(1);
    private  int nivel;

    Prioridade(int nivel)
    {
        this.nivel = nivel;
    }
    public int getNivel(){ return nivel;}
}

