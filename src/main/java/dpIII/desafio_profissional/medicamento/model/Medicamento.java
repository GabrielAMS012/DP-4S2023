package dpIII.desafio_profissional.medicamento.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Column(name = "receita_obrigatoria")
    private Boolean receitaObrigatoria;
    private String descricao;
    private String instrucoes;

}
