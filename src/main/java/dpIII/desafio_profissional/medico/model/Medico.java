package dpIII.desafio_profissional.medico.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String crm;
    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;
    private Boolean ativo;

}
