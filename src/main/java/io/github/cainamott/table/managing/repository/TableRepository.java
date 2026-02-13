package io.github.cainamott.table.managing.repository;

import io.github.cainamott.table.managing.model.entity.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface TableRepository extends MongoRepository<Table, UUID> {

    @Query("{id: '?0'}")
    Table findTableById(UUID id);
}
