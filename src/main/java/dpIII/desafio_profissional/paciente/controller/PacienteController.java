package dpIII.desafio_profissional.paciente.controller;

import dpIII.desafio_profissional.paciente.model.Medico;
import dpIII.desafio_profissional.paciente.repository.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medico>> getAll() {
        return ResponseEntity.ok(this.pacienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.pacienteRepository.findById(id).orElse(null));
    }

    @PostMapping("/save")
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return ResponseEntity.ok(this.pacienteRepository.save(medico));
    }

    @PutMapping("/update")
    public ResponseEntity<Medico> update(@RequestBody Medico updatedMedico) {
        Medico novoMedico = this.pacienteRepository.findById(updatedMedico.getId()).get();

        novoMedico.setAtivo(updatedMedico.getAtivo());
        novoMedico.setCpf(updatedMedico.getCpf());
        novoMedico.setNome(updatedMedico.getNome());
        novoMedico.setEndereco(updatedMedico.getEndereco());

        return ResponseEntity.ok(this.pacienteRepository.save(novoMedico));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.pacienteRepository.deleteById(id);
    }

}
