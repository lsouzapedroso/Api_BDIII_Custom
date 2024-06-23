package org.unicentro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.unicentro.domain.dto.usuario.UsuarioRequestDTO;
import org.unicentro.domain.dto.usuario.UsuarioResponseDTO;
import org.unicentro.domain.service.UsuarioService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> obterTodos(){
        return ResponseEntity.ok(usuarioService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioRequestDTO dto){
        UsuarioResponseDTO usuario = usuarioService.cadastrar(dto);
        return new ResponseEntity<UsuarioResponseDTO>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto){
        UsuarioResponseDTO usuario = usuarioService.atualizar(id, dto);
        return new ResponseEntity<UsuarioResponseDTO>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
