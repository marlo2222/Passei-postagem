package com.api.postagem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comentario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dataCriacao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataCriacao;

    @Column(name = "dataModificacao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataModificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_postagem")
    @JsonBackReference
    private Postagem postagem;

    @Column(name = "fk_usuario", nullable = false)
    private long usuario;


}
