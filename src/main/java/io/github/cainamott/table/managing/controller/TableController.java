package io.github.cainamott.table.managing.controller;

import io.github.cainamott.table.managing.exceptions.EntityNotFoundException;
import io.github.cainamott.table.managing.model.dto.TableDTO;
import io.github.cainamott.table.managing.model.entity.Table;
import io.github.cainamott.table.managing.model.entity.UpdateReservedStatusModel;
import io.github.cainamott.table.managing.model.entity.UpdateTableStatusModel;
import io.github.cainamott.table.managing.model.enums.TableStatus;
import io.github.cainamott.table.managing.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tables")
public class TableController {

    private TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<Table> createTable(@RequestBody TableDTO object){
        var objectCreated = tableService.createTable(object);
        return ResponseEntity.ok(objectCreated);
    }

    @GetMapping
    public ResponseEntity getAllTables() {
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity updateVacancyStatus(@RequestParam @PathVariable UUID id, @RequestBody TableStatus status){
        try {
            var entity = new UpdateTableStatusModel(id, status);
            tableService.updateVacancyStatus(entity);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
            return ResponseEntity.ok("Status Atualizado!");
    }

    @PutMapping
    public ResponseEntity updateReservedStatus(@RequestParam @PathVariable UUID id, @RequestBody Boolean reserve) {
        try {
            var entity = new UpdateReservedStatusModel(id, reserve);
            tableService.updateReservedStatus(entity);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok("Mesa Reservada!");
    }

    @DeleteMapping
    public ResponseEntity deleteTable(@PathVariable UUID id) {
        try {
            tableService.deleteTableById(id);
            return ResponseEntity.ok("Mesa deletada!");
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
