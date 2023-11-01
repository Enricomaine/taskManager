package com.taskManager.domain.tarefa;

public enum Status {
    aberto(1),
    finalizado(2),
    cancelado(3);

    Status(int numeroStatus) {
    }
}
