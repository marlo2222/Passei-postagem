package com.api.postagem.controller;

import com.api.postagem.models.Postagem;
import com.api.postagem.repository.PostagemRepository;
import com.api.postagem.services.PostagemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostagemController {

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    PostagemServices postagemServices;


    @GetMapping(value = "/postagem/listar")
    public ResponseEntity<?> listarPostagens(){
        return new ResponseEntity<>(postagemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/postagem/listar/{id}")
    public ResponseEntity<?> listarPostagemId(@PathVariable("id") long id){
        return new ResponseEntity<>(postagemRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/postagem/salvar")
    public ResponseEntity<?> salvarPostagem(@RequestBody Postagem postagem){
        postagemRepository.save(postagemServices.definirData(postagem));
        return new ResponseEntity<>("Salvo com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(value = "/postagem/deletar/{id}")
    public ResponseEntity<?> deletarPostagem(@PathVariable("id") long id){
        postagemRepository.deleteById(id);
        return new ResponseEntity<>("Removido com sucesso", HttpStatus.OK);
    }

    @PutMapping(value = "/postagem/atualizar")
    public ResponseEntity<?> atualizarPostagem(@RequestBody Postagem postagem){
        postagemRepository.save(postagemServices.atualizarData(postagem));
        return new ResponseEntity<>("Atualizado com sucesso", HttpStatus.OK);
    }
}
