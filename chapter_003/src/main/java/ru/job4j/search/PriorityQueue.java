package ru.job4j.search;

import java.util.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    int priority = 0;
    String indx = "";// список уровней приоритетов

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определятся по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
            if (indx.equals("")) {
                indx = indx + task.getPriority();
                tasks.add(0, task);
            }
            else if (indx.contains(String.valueOf(task.getPriority())) && tasks.size() > 1) {
                for (int i = 0; i < tasks.size(); i++) {
                    if (tasks.get(i).getPriority() == task.getPriority()) {
                        priority = i;
                        break;
                    }
                }
                tasks.add(priority, task);
            }
            else if (!indx.contains(String.valueOf(task.getPriority()))) {
                 for (int i = 0; i < tasks.size(); i++) {
                     if (tasks.get(i).getPriority() > task.getPriority()) {
                         priority = i;
                         indx = indx + task.getPriority();
                         break;
                     }
                     if (tasks.get(i).getPriority() < task.getPriority() && i == tasks.size() - 1) {
                                 priority = i + 1;
                                 indx = indx + task.getPriority();
                                 break;
                        } else if (tasks.get(i).getPriority() < task.getPriority() && task.getPriority() < tasks.get(i + 1).getPriority()) {
                                    priority = i + 1;
                                    indx = indx + task.getPriority();
                                    break;
                     }
                 }
                tasks.add(priority, task);
            }
    }
    public Task take() {
        return this.tasks.poll();
    }
}
