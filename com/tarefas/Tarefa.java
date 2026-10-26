package com.tarefas;

import com.status.Status;

import com.prioridade.Prioridade;

public class Tarefa<T> implements Comparable<Tarefa<T>>
{
    private Status status;
    private Prioridade prioridade;
    private T conteudo;

    public Tarefa(T conteudo, Prioridade prioridade)
    {
        this.conteudo = conteudo;
        this.status = Status.PENDENTE;
        this.prioridade = prioridade;
    }

    public Prioridade getPrioridade() { return prioridade; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) {this.status = status;}
    public void setPrioridade(Prioridade prioridade) {this.prioridade = prioridade;}

    @Override
    public int compareTo(Tarefa<T> o) {
        return Integer.compare(o.getPrioridade().getNivel(), prioridade.getNivel());
    }
    @Override
    public String toString() {
        if(conteudo.toString() == null ) return "NULL";
        return "CONTEUDO: " + conteudo + " STATUS: " + status + " PRIORIDADE: " + prioridade;
    }
}
