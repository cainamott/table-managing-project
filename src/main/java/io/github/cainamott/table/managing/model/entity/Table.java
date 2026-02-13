package io.github.cainamott.table.managing.model.entity;

import io.github.cainamott.table.managing.utils.TableStatus;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Table {

    private UUID id;
    private String name;
    private LocalDate creationDate;
    private int seats;
    private TableStatus status;
    private Boolean reserved;


}
