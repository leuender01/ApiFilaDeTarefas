package com;

import com.gerenciadorTarefas.GerenciadorTarefas;
import com.prioridade.Prioridade;

public class App {
    public static void main(String[] args) {
        GerenciadorTarefas<String> gerenciadorTarefas = new GerenciadorTarefas<>();
        gerenciadorTarefas.add("Ola mundo", Prioridade.BAIXA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.BAIXA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.BAIXA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.BAIXA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.ALTA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.ALTA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.ALTA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.BAIXA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.MEDIA);
        gerenciadorTarefas.add("Ola mundo", Prioridade.URGENTE);
        gerenciadorTarefas.add("Ola mundo", Prioridade.URGENTE);
        gerenciadorTarefas.add("Ola mundo", Prioridade.URGENTE);
        gerenciadorTarefas.execultarTask();
        while (true)
        {
            try {
                Thread.sleep(300);
                System.out.println("\033[2J\033[H");
                System.out.println(gerenciadorTarefas);
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }
}
