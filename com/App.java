package com;

import com.prioridade.Prioridade;
import com.tarefas.Tarefa;

public class App {
    public static void main(String[] args) {
        Tarefa[] tarefas =  new Tarefa[]
        {
            new Tarefa<String>("Ola mundo", Prioridade.BAIXA),
            new Tarefa<String>("Tachau mundo", Prioridade.MEDIA),
            new Tarefa<String>("Cava mundo", Prioridade.ALTA),
            new Tarefa<String>("Sevidor", Prioridade.URGENTE)
        };
        for(var tarefa : tarefas)
        {
            System.out.println(tarefa);

        }
        System.out.println(tarefas[2].compareTo(tarefas[1]));
        
    }
}
