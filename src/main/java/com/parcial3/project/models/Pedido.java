package com.parcial3.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    private String id;
    private String descripcion;
    private double total;
}
