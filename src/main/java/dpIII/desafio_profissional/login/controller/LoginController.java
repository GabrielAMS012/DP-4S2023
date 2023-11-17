package dpIII.desafio_profissional.login.controller;

import dpIII.desafio_profissional.login.model.Login;
import dpIII.desafio_profissional.login.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LoginController {

    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Login>> getAll() {
        return ResponseEntity.ok(this.loginRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.loginRepository.findById(id).orElse(null));
    }

    @PostMapping("/save")
    public ResponseEntity<Login> save(@RequestBody Login Login) {
        return ResponseEntity.ok(this.loginRepository.save(Login));
    }

    @PutMapping("/update")
    public ResponseEntity<Login> update(@RequestBody Login updatedLogin) {
        Login novoLogin = this.loginRepository.findById(updatedLogin.getId()).get();

        novoLogin.setTipoLogin(updatedLogin.getTipoLogin());
        novoLogin.setUsuario(updatedLogin.getUsuario());
        novoLogin.setSenha(updatedLogin.getSenha());
        novoLogin.setCodigoCadastro(updatedLogin.getCodigoCadastro());

        return ResponseEntity.ok(this.loginRepository.save(novoLogin));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.loginRepository.deleteById(id);
    }

}
