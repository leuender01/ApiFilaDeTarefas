package com.gerenciadorTarefas;

import com.status.Status;
import java.util.List;
import com.prioridade.Prioridade;
import com.tarefas.Tarefa;

public interface GerenciadorTarefasInterfaces<T>
{
    public void add(T o, Prioridade prioridade);
    public boolean execultarTask();
    public List<Tarefa<T>> filter(Prioridade prioridade);
    public List<Tarefa<T>> filter(Status status);
    public Tarefa<T> currentTasks();
}
