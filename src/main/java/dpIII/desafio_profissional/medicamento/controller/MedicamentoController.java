package dpIII.desafio_profissional.medicamento.controller;

import dpIII.desafio_profissional.medicamento.model.Medicamento;
import dpIII.desafio_profissional.medicamento.repository.MedicamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {


    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoController(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Medicamento>> getAll() {
        return ResponseEntity.ok(this.medicamentoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.medicamentoRepository.findById(id).orElse(null));
    }

    @PostMapping("/save")
    public ResponseEntity<Medicamento> save(@RequestBody Medicamento Medicamento) {
        return ResponseEntity.ok(this.medicamentoRepository.save(Medicamento));
    }

    @PutMapping("/update")
    public ResponseEntity<Medicamento> update(@RequestBody Medicamento updatedMedicamento) {
        Medicamento novoMedicamento = this.medicamentoRepository.findById(updatedMedicamento.getId()).get();

        novoMedicamento.setDescricao(updatedMedicamento.getDescricao());
        novoMedicamento.setNome(updatedMedicamento.getNome());
        novoMedicamento.setInstrucoes(updatedMedicamento.getInstrucoes());
        novoMedicamento.setReceitaObrigatoria(updatedMedicamento.getReceitaObrigatoria());

        return ResponseEntity.ok(this.medicamentoRepository.save(novoMedicamento));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.medicamentoRepository.deleteById(id);
    }

}
