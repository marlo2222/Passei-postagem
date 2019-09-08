package com.api.postagem.services;

import com.api.postagem.models.Postagem;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostagemServices {

    public Postagem definirData(Postagem postagem){
        postagem.setDataCriacao(new Date());
        postagem.setDataModificacao(new Date());
        return postagem;
    }

    public Postagem atualizarData(Postagem postagem){
        postagem.setDataModificacao(new Date());
        return postagem;
    }
}
