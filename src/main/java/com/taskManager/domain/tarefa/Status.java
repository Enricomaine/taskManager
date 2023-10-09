package com.taskManager.domain.tarefa;

public enum Status {
    aberto(1),
    finalizado(2),
    cancelado(3);

    private final int numeroStatus;

    Status(int numeroStatus) {
        this.numeroStatus = numeroStatus;
    }
}
