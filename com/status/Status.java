package com.status;

public enum Status
{
    CONCLUIDA(0),
    EM_EXECUCAO(1),
    PENDENTE(2);
    private int nivel;
    private Status(int nivel)
    {
        this.nivel = nivel;
    }
    public int getNivel() {
        return nivel;
    }
}
