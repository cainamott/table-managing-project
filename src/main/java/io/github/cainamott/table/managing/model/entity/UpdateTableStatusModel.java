package io.github.cainamott.table.managing.model.entity;

import io.github.cainamott.table.managing.model.enums.TableStatus;

import java.util.UUID;

public record UpdateTableStatusModel(UUID id, TableStatus status){
}
