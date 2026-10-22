package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class QueuePrioridade<T> extends PriorityQueue<Tarefas<T>>
{
    public String filter(Prioridade prioridade)
    {
        Object[] array = toArray();
        return array.toString();
    }
    public List<Tarefas<T> > filter(Status prioridade)
    {
        List<Tarefas <T>> builder = new ArrayList<>();
        Object[] array = toArray();
        Arrays.stream(array).filter((it) ->  it.getStatus()).forEach(System.out::println);
        return builder;
    }

}
