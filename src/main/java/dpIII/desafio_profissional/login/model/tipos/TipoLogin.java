package dpIII.desafio_profissional.login.model.tipos;

import lombok.Getter;

@Getter
public enum TipoLogin {

    MEDICO("medico"),
    PACIENTE("paciente"),
    ADMINISTRADOR("admin");

    private String nome;

    TipoLogin(String nome) {
        this.nome = nome;
    }
}
