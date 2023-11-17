package dpIII.desafio_profissional.login.model;


import dpIII.desafio_profissional.login.model.tipos.TipoLogin;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo_cadastro")
    private Long codigoCadastro;

    @Column(name = "tipo_login")
    private TipoLogin tipoLogin;

    private String usuario;
    private String senha;

}
