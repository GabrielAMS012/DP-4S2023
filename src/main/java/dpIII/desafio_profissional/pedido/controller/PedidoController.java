package dpIII.desafio_profissional.pedido.controller;

import dpIII.desafio_profissional.pedido.model.Pedido;
import dpIII.desafio_profissional.pedido.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> getAll() {
        return ResponseEntity.ok(this.pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.pedidoRepository.findById(id).orElse(null));
    }

    @PostMapping("/save")
    public ResponseEntity<Pedido> save(@RequestBody Pedido Pedido) {
        return ResponseEntity.ok(this.pedidoRepository.save(Pedido));
    }

    @PutMapping("/update")
    public ResponseEntity<Pedido> update(@RequestBody Pedido updatedPedido) {
        Pedido novoPedido = this.pedidoRepository.findById(updatedPedido.getId()).get();

        novoPedido.setDataPedido(updatedPedido.getDataPedido());
        novoPedido.setMedicamentos(updatedPedido.getMedicamentos());
        novoPedido.setDataPedido(updatedPedido.getDataPedido());
        novoPedido.setFrequencia(updatedPedido.getFrequencia());
        novoPedido.setCodMedico(updatedPedido.getCodMedico());
        novoPedido.setDataFinal(updatedPedido.getDataFinal());

        return ResponseEntity.ok(this.pedidoRepository.save(novoPedido));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.pedidoRepository.deleteById(id);
    }

}
