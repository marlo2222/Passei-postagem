package com.api.postagem.repository;

import com.api.postagem.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    Postagem findById(long id);
}
