package dpIII.desafio_profissional.medico.repository;

import dpIII.desafio_profissional.medico.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
