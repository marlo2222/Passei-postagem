package com.api.postagem.controller;

import com.api.postagem.models.Postagem;
import com.api.postagem.repository.PostagemRepository;
import com.api.postagem.services.PostagemServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postagem")
@Api(value = "API de favoritos")
public class PostagemController {

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    PostagemServices postagemServices;

    @GetMapping(value = "/")
    @ApiOperation(value = "retorna uma string")
    public String home(){
        return "Deu certo";
    }

    @GetMapping(value = "/postagem")
    @ApiOperation(value = "retorna uma lista de postagem")
    public ResponseEntity<?> listarPostagens(){
        return new ResponseEntity<>(postagemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/postagem/{id}")
    @ApiOperation(value = "retorna uma postagem pelo id")
    public ResponseEntity<?> listarPostagemId(@PathVariable("id") long id){
        return new ResponseEntity<>(postagemRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/postagem")
    @ApiOperation(value = "salva uma postagem")
    public ResponseEntity<?> salvarPostagem(@RequestBody Postagem postagem){
        postagemRepository.save(postagemServices.definirData(postagem));
        return new ResponseEntity<>("Salvo com sucesso", HttpStatus.OK);
    }

    @DeleteMapping(value = "/postagem/{id}")
    @ApiOperation(value = "delete uma postagem")
    public ResponseEntity<?> deletarPostagem(@PathVariable("id") long id){
        postagemRepository.deleteById(id);
        return new ResponseEntity<>("Removido com sucesso", HttpStatus.OK);
    }

    @PutMapping(value = "/postagem")
    @ApiOperation(value = "atualiza uma postagem")
    public ResponseEntity<?> atualizarPostagem(@RequestBody Postagem postagem){
        postagemRepository.save(postagemServices.atualizarData(postagem));
        return new ResponseEntity<>("Atualizado com sucesso", HttpStatus.OK);
    }
}
