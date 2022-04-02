package test;

import org.junit.jupiter.api.Test;

import org.junit.Before;
import entidades.Filme;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class TesteFilme {

    @Test
    //Teste para Cadastrar Funcionário no filme
    //Primeiro Teste é cadastro, dps tenta cadastrar de novo e da falso, pq ja ta cadastrado
    public void testeCadastrarFuncionarioAtor(){
        Filme filme = new Filme("O Auto da Compadecida", 2000);
        assertTrue(filme.cadastrarFuncionario("Selton Melo", new ArrayList<>(List.of("Ator"))));
        assertFalse(filme.cadastrarFuncionario("Selton Melo", new ArrayList<>(List.of("Ator"))));
    }

    @Test
    public void testeCadastrarFuncionarioDiretoreRoteirista(){
        Filme filme1 = new Filme("O Homem Que Desafiou o Diabo", 2007);
        assertTrue(filme1.cadastrarFuncionario("Moacyr Góes", new ArrayList<>(List.of("Diretor", "Roteirista"))));
        assertFalse(filme1.cadastrarFuncionario("Moacyr Góes", new ArrayList<>(List.of("Diretor", "Roteirista"))));

    }

    @Test
    public void testeCadastrarFuncionarioDiretor(){
        Filme filme2 = new Filme("Map - o filme", 2022);
        assertTrue(filme2.cadastrarFuncionario("Sabrina", new ArrayList<>(List.of("Diretor"))));
        assertFalse(filme2.cadastrarFuncionario("Sabrina", new ArrayList<>(List.of("Diretor"))));
    }

}
