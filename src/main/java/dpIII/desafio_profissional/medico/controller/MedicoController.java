package dpIII.desafio_profissional.medico.controller;

import dpIII.desafio_profissional.medico.model.Medico;
import dpIII.desafio_profissional.medico.repository.MedicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {


    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medico>> getAll() {
        return ResponseEntity.ok(this.medicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.medicoRepository.findById(id).orElse(null));
    }

    @PostMapping("/save")
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return ResponseEntity.ok(this.medicoRepository.save(medico));
    }

    @PutMapping("/update")
    public ResponseEntity<Medico> update(@RequestBody Medico updatedMedico) {
        Medico novoMedico = this.medicoRepository.findById(updatedMedico.getId()).get();

        novoMedico.setAtivo(updatedMedico.getAtivo());
        novoMedico.setCrm(updatedMedico.getCrm());
        novoMedico.setNome(updatedMedico.getNome());
        novoMedico.setDataNascimento(updatedMedico.getDataNascimento());

        return ResponseEntity.ok(this.medicoRepository.save(novoMedico));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.medicoRepository.deleteById(id);
    }

}
