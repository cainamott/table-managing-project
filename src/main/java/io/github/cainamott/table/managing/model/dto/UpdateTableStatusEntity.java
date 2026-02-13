package io.github.cainamott.table.managing.model.dto;

import io.github.cainamott.table.managing.utils.TableStatus;

import java.util.UUID;

public record UpdateTableStatusEntity (UUID id, TableStatus status){
}
