package com.api.postagem.controller;

import com.api.postagem.models.Comentario;
import com.api.postagem.models.Postagem;
import com.api.postagem.repository.ComentarioRepository;
import com.api.postagem.repository.PostagemRepository;
import com.api.postagem.services.ComentarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private PostagemRepository postagemRepository;
    @Autowired
    private ComentarioServices comentarioServices;

    @GetMapping(value = "/comentario/listar")
    public ResponseEntity<?> listarComentarios(){
        return new ResponseEntity<>(comentarioRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/comentario/listar/{id}")
    public ResponseEntity<?> listarComentarioId(@PathVariable("id") long id){
        return new ResponseEntity<>(comentarioRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/comentario/salvar")
    public ResponseEntity<?> salvarComentario(@RequestBody Comentario comentario){
        Postagem postagem = new Postagem();
        postagem = postagemRepository.findById(comentario.getPostagem().getId());
        comentario.setPostagem(postagem);
        comentarioRepository.save(comentarioServices.definirData(comentario));
        return new ResponseEntity<>("Salvo com sucesso", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/comentario/deletar/{id}")
    public ResponseEntity<?> deletarComentario(@PathVariable("id") long id){
        comentarioRepository.deleteById(id);
        return new ResponseEntity<>("deletado  com sucesso", HttpStatus.OK);
    }

    @PutMapping(value = "/comentario/atualizar")
    public ResponseEntity<?> atualizarComentario(@RequestBody Comentario comentario){
        comentarioRepository.save(comentarioServices.atualizarData(comentario));
        return  new ResponseEntity<>("atualizado com sucesso", HttpStatus.OK);
    }
}
