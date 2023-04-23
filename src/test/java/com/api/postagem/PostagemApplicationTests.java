package com.api.postagem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.postagem.models.Postagem;
import com.api.postagem.repository.PostagemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostagemApplicationTests {
	
	@Autowired
    PostagemRepository postagemRepository;

	@Test
	public void contextLoads() {
	}

	@Test
    public void testFindById() {
        Postagem postagem = new Postagem();
        postagem.setId(1L);
        postagem.setTitulo("Título da postagem");
        postagem.setDescicao("Descrição da postagem");
        
        postagemRepository.save(postagem);
        Postagem postagemEncontrada = postagemRepository.findById(postagem.getId());
        
        assertNotNull(postagemEncontrada);
        assertEquals(postagem.getId(), postagemEncontrada.getId());
        assertEquals(postagem.getTitulo(), postagemEncontrada.getTitulo());
        assertEquals(postagem.getDescicao(), postagemEncontrada.getDescicao());
    };
}
