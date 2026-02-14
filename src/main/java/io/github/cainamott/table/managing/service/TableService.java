package io.github.cainamott.table.managing.service;

import io.github.cainamott.table.managing.exceptions.EntityNotFoundException;
import io.github.cainamott.table.managing.model.dto.TableDTO;
import io.github.cainamott.table.managing.model.entity.UpdateTableStatusModel;
import io.github.cainamott.table.managing.model.entity.Table;
import io.github.cainamott.table.managing.repository.TableRepository;
import io.github.cainamott.table.managing.model.enums.TableStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class TableService {

    private TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Table createTable(TableDTO object){
        var table = Table
                .builder()
                .id(UUID.randomUUID())
                .name(object.getName())
                .creationDate(LocalDate.now())
                .seats(object.getSeats())
                .status(TableStatus.VACANT)
                .reserved(Boolean.FALSE)
                .build();
        return tableRepository.save(table);
    };

    public Table updateTableStatus(UpdateTableStatusModel entity){
        Table table = findTableById(entity.id());
        if(table != null){
            table.setStatus(entity.status());
            return tableRepository.save(table);
        }else {
            throw new EntityNotFoundException("Mesa não encontrada");
        }
    }

    public Table findTableById(UUID id){
        return tableRepository.findTableById(id);
    }

}
