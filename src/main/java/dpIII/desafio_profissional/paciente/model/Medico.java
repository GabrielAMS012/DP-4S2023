package dpIII.desafio_profissional.paciente.model;

import dpIII.desafio_profissional.paciente.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private Boolean ativo;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

}
