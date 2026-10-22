package com;

public class Tarefas<T> implements Comparable< Tarefas<T> >
{
    private T conteudo;
    private Prioridade prioridade;
    private Status status; 

    public Tarefas (T conteudo, Prioridade prioridade)
    {
        this.conteudo = conteudo;
        this.prioridade = prioridade;
        this.status = Status.PENDENTE;
    }

    @Override
    public int compareTo(Tarefas<T> outra) {
        return Integer.compare(this.prioridade.getNivel(), outra.prioridade.getNivel());
    }
    public Prioridade getPrioridade(){ return this.prioridade; }
    public Status getStatus() { return this.status; }
    public void setStatus(Status status) { this.status = status;  }
    @Override
    public String toString() {
        if(this.conteudo != null) return "Status:  " + this.status + "  Prioridade: " + this.prioridade  ;
        return "NULL";
    }
}
