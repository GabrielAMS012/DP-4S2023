package dpIII.desafio_profissional.pedido.model;

import dpIII.desafio_profissional.medicamento.model.Medicamento;
import dpIII.desafio_profissional.pedido.model.frequencia.Frequencia;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinColumn(name = "id_medicamento")
    private List<Medicamento> medicamentos;
    @Column(name = "cod_medico")
    private Long codMedico;
    @Column(name = "data_pedido")
    private Date dataPedido;
    @Column(name = "data_final")
    private Date dataFinal;
    private Frequencia frequencia;
}
