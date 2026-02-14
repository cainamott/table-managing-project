package io.github.cainamott.table.managing.controller;

import io.github.cainamott.table.managing.exceptions.EntityNotFoundException;
import io.github.cainamott.table.managing.model.dto.TableDTO;
import io.github.cainamott.table.managing.model.entity.Table;
import io.github.cainamott.table.managing.model.entity.UpdateTableStatusModel;
import io.github.cainamott.table.managing.service.TableService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok("Funcionando!");
    }

    @PutMapping("{id}")
    public ResponseEntity updateTableStatus(@RequestParam @PathVariable UUID id, @RequestBody UpdateTableStatusModel status){
        try {
            updateTableStatus(id, status);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
            return ResponseEntity.ok("Status Atualizado!");
    }


}
