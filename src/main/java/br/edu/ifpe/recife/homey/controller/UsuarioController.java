package br.edu.ifpe.recife.homey.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.recife.homey.dto.CriarClienteDTO;
import br.edu.ifpe.recife.homey.dto.CriarPrestadorDTO;
import br.edu.ifpe.recife.homey.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/prestador")
    public ResponseEntity<?> criarPrestador(@Valid @RequestBody CriarPrestadorDTO dto) throws Exception {
        return ResponseEntity.ok(usuarioService.criaPrestador(dto));
    }

    @PostMapping("/cliente")
    public ResponseEntity<?> criarCliente(@Valid @RequestBody CriarClienteDTO dto) throws Exception {
        return ResponseEntity.ok(usuarioService.criaCliente(dto));
    }

    @GetMapping("/prestador/{id}")
    public ResponseEntity<?> pegarPrestador(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.pegarPrestador(id));
    }
    
}
