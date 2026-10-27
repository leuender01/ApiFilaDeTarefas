package com.gerenciadorTarefas;

import com.status.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.prioridade.Prioridade;
import com.tarefas.Tarefa;


public class GerenciadorTarefas<T> implements GerenciadorTarefasInterfaces<T>
{
    private Queue<Tarefa <T>> tarefasEmExecucao = new PriorityQueue<>();
    private Queue<Tarefa<T>> tarefasPendente = new PriorityQueue<>();
    private Queue<Tarefa<T>> tarefasCocluidas = new PriorityQueue<>();
    private Thread threadTrabalho = new Thread(() -> {
            while(!tarefasEmExecucao.isEmpty() || !tarefasPendente.isEmpty()){
                while(tarefasEmExecucao.size() < 5 && !tarefasPendente.isEmpty()){
                    Tarefa<T> task = tarefasPendente.poll();
                    task.setStatus(Status.EM_EXECUCAO);
                    tarefasEmExecucao.add(task);
                }
                try {
                    Thread.sleep(2000);
                    Tarefa<T> tarefa = tarefasEmExecucao.poll(); 
                    tarefa.setStatus(Status.CONCLUIDA);
                    tarefasCocluidas.add(tarefa);
                } catch (Exception e) {
                }
            }
        });
    @Override
    public void add(T conteudo, Prioridade prioridade) 
    {
//        Prioridade prioridade = tarefa.getPrioridade();
        Tarefa<T> tarefa = new Tarefa<>(conteudo , prioridade);
        tarefasPendente.add(tarefa);
    }
    @Override
    public boolean execultarTask()
    {
        this.threadTrabalho.start();
        return true;
    }
    @Override
    public List<Tarefa<T>> filter(Status status) {
        if(status == null) return null;
        List<Tarefa<T>> resultado = new ArrayList<>();
        if(status == Status.CONCLUIDA){
            tarefasCocluidas.stream()
            .forEach(resultado::add);
        }else if(status == Status.PENDENTE){
            tarefasPendente.stream()
            .forEach(resultado::add);

        }else{
            tarefasEmExecucao.stream()
            .forEach(resultado::add);
        }
        return resultado;
    }

    @Override
    public List<Tarefa<T>> filter(Prioridade prioridade) {
        List<Tarefa<T>> resultado = new ArrayList<>();
        tarefasPendente.stream()
        .filter(it -> it.getPrioridade() == prioridade)
        .forEach(resultado::add);

        tarefasCocluidas.stream()
        .filter(it -> it.getPrioridade() == prioridade)
        .forEach(resultado::add);

        tarefasEmExecucao.stream()
        .filter(it -> it.getPrioridade() == prioridade)
        .forEach(resultado::add);
        return resultado;
    }
    @Override
    public Tarefa<T> currentTasks() {
        return null;
    }
    @Override
    public String toString() {
        return "EM_EXECUCAO: " + tarefasEmExecucao + "\nPENDENTES: " + tarefasPendente + "\nCONCLUIDAS: " + tarefasCocluidas;
    }
    public Queue<Tarefa<T>> getQueuen()
    {
        return tarefasEmExecucao;
    }
}
