package io.github.cainamott.table.managing.controller;

import io.github.cainamott.table.managing.model.dto.TableDTO;
import io.github.cainamott.table.managing.model.entity.Table;
import io.github.cainamott.table.managing.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity recado(){
        return ResponseEntity.ok("Funcionando!");
    }
}
