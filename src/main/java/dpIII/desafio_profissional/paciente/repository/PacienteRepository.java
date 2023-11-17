package dpIII.desafio_profissional.paciente.repository;

import dpIII.desafio_profissional.paciente.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Medico, Long> {
}
