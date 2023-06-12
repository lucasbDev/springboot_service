package com.RHPback.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RHPback.projeto.entities.RespostaModelo;
import com.RHPback.projeto.entities.Reuniao;
import com.RHPback.projeto.service.ReuniaoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reuniao")
public class ReuniaoController {

    @Autowired
    private ReuniaoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Reuniao>> findAll() {
        List<Reuniao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reuniao> findById(@PathVariable Long id) {
        Reuniao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> insert(@RequestBody Reuniao obj) {
        ResponseEntity<?> resposta = service.cadastrar(obj, "cadastrar");
        return ResponseEntity.ok().body(resposta);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> update(@RequestBody Reuniao obj) {
        ResponseEntity<?> resposta = service.cadastrar(obj, "alterar");
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<ResponseEntity<RespostaModelo>> remover(@PathVariable long codigo) {
        ResponseEntity<RespostaModelo> resposta = service.remover(codigo);
        return ResponseEntity.ok().body(resposta);
    }
}
