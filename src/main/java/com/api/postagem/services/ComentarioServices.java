package com.api.postagem.services;

import com.api.postagem.models.Comentario;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ComentarioServices {

    public Comentario definirData(Comentario comentario){
        comentario.setDataCriacao(new Date());
        comentario.setDataModificacao(new Date());
        return comentario;
    }

    public Comentario atualizarData(Comentario comentario){
        comentario.setDataModificacao(new Date());
        return comentario;
    }

}
