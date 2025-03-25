package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNome;

    private LocalDate dataPedido;

    private double valorTotal;

    // Preenche a dataPedido com a data atual, se não estiver definida
    @PrePersist
    public void prePersist() {
        if (dataPedido == null) {
            dataPedido = LocalDate.now();
        }
    }
}
