package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import entidades.GloboFilmes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import exceptions.FilmeNotFoundException;

public class TesteGloboFilmes {
    static GloboFilmes globoFilmes;
    static GloboFilmes filmeteste;

    @BeforeAll
    public static void setUp() {
        //Cadastra filme em globoFilme
        globoFilmes = new GloboFilmes();

        /*O Map.ofEntries é um Map não modificáveis contendo mapeamento especificado, onde após a sua criação,
        as chaves e valores não podem ser adicionados, apagados e atualizados e se tentarmos realizar essas operações
        as excessões serão lançadas
         */
        globoFilmes.cadastrarFilme("O Auto da Compadecida", 2000, Map.ofEntries(
                        Map.entry("Guel Arraes", new ArrayList<>(List.of("Diretor"))),
                        Map.entry("Selton Melo", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Denise Fraga", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Félix Monti", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("Aboio", "Presepada", "Régia")));

        filmeteste = new GloboFilmes();

        filmeteste.cadastrarFilme("O Auto da Compadecida", 2000, Map.ofEntries(
                        Map.entry("Guel Arraes", new ArrayList<>(List.of("Diretor"))),
                        Map.entry("Selton Melo", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Denise Fraga", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Félix Monti", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("Aboio", "Presepada", "Régia")));
    }

    @Test
    //Teste para verificar se o filme não existe
    public void TesteParaCadastrarFilmeTrue() {
        assertTrue(globoFilmes.cadastrarFilme("O Homem Que Desafiou o Diabo", 2007, Map.ofEntries(
                        Map.entry("Moacyr Góes", new ArrayList<>(List.of("Diretor", "Roteirista"))),
                        Map.entry("Marcos Palmeira", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Lívia Falcão", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Jacques Cheuiche", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("Não grude não", "Sim foi você", "Boi Tungão"))));
    }

    @Test
    //Teste para verificar se o filme ja existe
    public void TesteParaCadastrarFilmeFalse() {
        assertFalse(globoFilmes.cadastrarFilme("O Auto da Compadecida", 2000, Map.ofEntries(
                        Map.entry("Guel Arraes", new ArrayList<>(List.of("Diretor"))),
                        Map.entry("Selton Melo", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Denise Fraga", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Félix Monti", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("Aboio", "Presepada", "Régia"))));
    }

    @Test
    //Teste para Filmografia em Filme teste e Globo filmes
    public void TesteParaMostrarFilmografia(){
        assertEquals(filmeteste.mostrarFilmografia("Selton Melo", "Ator"),
                globoFilmes.mostrarFilmografia("Selton Melo", "Ator"));
    }

    @Test
    //Teste que verifica se "O Auto da Compadecida" tem em Filme teste e Globo filmes
    public void TesteParaVerificarSeGloboFilmesEFilmeTeste() throws FilmeNotFoundException{
        assertEquals(globoFilmes.mostrarInformacoesFilme("O Auto da Compadecida"),
                filmeteste.mostrarInformacoesFilme("O Auto da Compadecida"));
    }

    //Teste de exceção para filme que não existe em Globo filmes
    @Test
    public void TesteExceptionFilme(){
        assertThrows(FilmeNotFoundException.class, () -> {
            globoFilmes.mostrarInformacoesFilme("O cravo e a Rosa");
        });
    }

    @Test
    //Teste de exceção para filme que não existe em Filme Teste
    public void TesteExceptionFilme2(){
        assertThrows(FilmeNotFoundException.class, () -> {
            filmeteste.mostrarInformacoesFilme("Borboletinha");
        });
    }
}


