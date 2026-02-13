package io.github.cainamott.table.managing.service;

import io.github.cainamott.table.managing.model.dto.TableDTO;
import io.github.cainamott.table.managing.model.dto.UpdateTableStatusEntity;
import io.github.cainamott.table.managing.model.entity.Table;
import io.github.cainamott.table.managing.repository.TableRepository;
import io.github.cainamott.table.managing.utils.TableStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
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

    public Table updateTableStatus(UpdateTableStatusEntity entity){
        Table table = tableRepository.findTableById(entity.id());
        if(table != null){
            table.setStatus(entity.status());
            return tableRepository.save(table);
        }else {
            return null;
        }
    }
}
