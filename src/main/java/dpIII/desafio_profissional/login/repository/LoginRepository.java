package dpIII.desafio_profissional.login.repository;

import dpIII.desafio_profissional.login.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
