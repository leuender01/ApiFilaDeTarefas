# ApiFilaDeTarefas

Desafio 3 do roteiro de estudos de POO em Java para backend: uma fila de tarefas em memória que aceita tarefas com prioridade, status (`PENDENTE`, `EM_EXECUCAO`, `CONCLUIDA`) e permite listar/filtrar por status usando a Stream API do Java.

## Conceitos trabalhados

- Enums (`Status`, `Prioridade`)
- Generics (`Tarefa<T>`, `GerenciadorTarefas<T>`)
- Collections (`PriorityQueue`, `ArrayList`)
- Stream API (`stream()`, `filter()`, `forEach()`)
- Interfaces separando contrato de implementação

## Estrutura do projeto

```
ApiFilaDeTarefas/
├── com/
│   ├── App.java                      # Ponto de entrada e demo de uso
│   ├── gerenciadorTarefas/
│   │   ├── GerenciadorTarefas.java   # Implementação da fila de tarefas
│   │   └── GerenciadorTarefasInterfaces.java  # Interface do gerenciador
│   ├── prioridade/
│   │   └── Prioridade.java           # Enum de prioridades (BAIXA, MEDIA, ALTA, URGENTE, FINALIZADA)
│   ├── status/
│   │   └── Status.java               # Enum de status (PENDENTE, EM_EXECUCAO, CONCLUIDA)
│   └── tarefas/
│       └── Tarefa.java               # Classe generica de tarefa (Comparable)
```

## Como compilar e executar

Requer Java 27 e javac 27.

```bash
cd ~/UNIALFA/java/ApiFilaDeTarefas

# Compila todos os fontes
javac com/**/*.java

# Executa a demo
java com.App
```

## Uso rápido

```java
GerenciadorTarefas<String> gerenciador = new GerenciadorTarefas<>();

gerenciador.add("Processar lote A", Prioridade.ALTA);
gerenciador.add("Enviar e-mail", Prioridade.BAIXA);
gerenciador.add("Gerar relatorio", Prioridade.URGENTE);

gerenciador.execultarTask();

// Lista tarefas por status
List<Tarefa<String>> pendentes = gerenciador.filter(Status.PENDENTE);
List<Tarefa<String>> concluidas = gerenciador.filter(Status.CONCLUIDA);

// Lista tarefas por prioridade
List<Tarefa<String>> urgentes = gerenciador.filter(Prioridade.URGENTE);
```

## Classes

### `Tarefa<T>`
Representa uma tarefa generica com conteudo, prioridade e status. Implementa `Comparable<Tarefa<T>>` ordenando por prioridade (maior nivel primeiro).

### `Status`
Enum com `PENDENTE`, `EM_EXECUCAO`, `CONCLUIDA`.

### `Prioridade`
Enum com `FINALIZADA`, `BAIXA`, `MEDIA`, `ALTA`, `URGENTE`, cada uma com um nivel numerico.

### `GerenciadorTarefas<T>`
Gerencia tres filas internas (pendentes, em execucao, concluidas) usando `PriorityQueue`. Possui uma thread de trabalho que move tarefas de pendente para executando e depois para concluida.

### `GerenciadorTarefasInterfaces<T>`
Interface que expõe `add`, `execultarTask`, `filter(Status)`, `filter(Prioridade)` e `currentTasks`.

## Observacoes do desafio

O desafio pede filtrar/listar por status usando Streams. Isso esta implementado nos metodos `filter(Status)` e `filter(Prioridade)` de `GerenciadorTarefas`.

Pontos para melhorar futuramente (nao bloqueantes para entrega):
- `currentTasks()` retorna `null` (nao implementado).
- `Tarefa.toString()` pode lancar `NullPointerException` se o conteudo for `null`.
- A thread de trabalho nao verifica se `poll()` retornou `null` antes de alterar o status da tarefa.
