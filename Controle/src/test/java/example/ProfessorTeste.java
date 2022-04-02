package example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.entidades.*;

public class ProfessorTeste {
    static ControleAcademico ca;

    @Before
    public void setUp() {

        ca = new ControleAcademico();

		ca.cadastrarTurma("Metodos Avancados de Programacao", "Terca", "11:00");
		ca.cadastrarTurma("Banco de Dados", "Terca", "07:00");
		ca.cadastrarTurma("Redes de Computadores", "Quarta", "11:00");
		ca.cadastrarTurma("Computacao Grafica", "Terca", "18:00");
		ca.cadastrarTurma("Paradigmas de Programacao", "Segunda", "11:00");
		ca.cadastrarTurma("Probabilidade e Estatastica 2", "Terca","09:00");
		ca.cadastrarTurma("Tecnicas de Analises de Algoritmos", "Quarta", "18:00");
		ca.cadastrarTurma("Engenharia de Software 1", "Segunda", "09:00");
        ca.cadastrarTurma("Calculo 3", "Sexta", "07:00");
        ca.cadastrarTurma("Linguagem de Programacao", "Quarta", "09:00");

		ca.cadastrarProfessores("Sabrina", 101);
		ca.cadastrarProfessores("Fabio", 102);
		ca.cadastrarProfessores("Janderson", 103);
		ca.cadastrarProfessores("Ana Isabella", 104);
		ca.cadastrarProfessores("Paulo", 105);
		ca.cadastrarProfessores("Elaine", 106);
		ca.cadastrarProfessores("Robson", 107);
        ca.cadastrarProfessores("Luciana", 108);

        ca.definirProfessorNaDisciplina("Fabio", "Banco de Dados");
		ca.definirProfessorNaDisciplina("Sabrina", "Metodos Avancados de Programacao");
		ca.definirProfessorNaDisciplina("Paulo", "Redes de Computadores");
		ca.definirProfessorNaDisciplina("Janderson", "Paradigmas de Programação");
		ca.definirProfessorNaDisciplina("Ana Isabella", "Engenharia de Software 1");
		ca.definirProfessorNaDisciplina("Elaine", "Probabilidade e Estatastica 2");
		ca.definirProfessorNaDisciplina("Paulo", "Tecnicas de Analises de Algoritmos");
		ca.definirProfessorNaDisciplina("Robson", "Computacao Grafica");
    }
    //_______________________________________________________________________________________________________

    @Test
    // adicionando um professor a disciplina
    public void testeProfessorAddDisciplina(){
        assertTrue(ca.definirProfessorNaDisciplina("Sabrina", "Calculo 3"));
    }

    @Test
    // adicionando um professor a uma disciplina que já tem professor
    public void testAdicionarProfessorJaNaDisciplina(){
        assertFalse(ca.definirProfessorNaDisciplina("Sabrina", "Metodos Avançados de Programacao"));
    }

    @Test
    //testar numero de disciplina do professor
    public void testNumDisciplinas(){
        assertEquals(2, ca.getProfessor("Paulo").getRdm().getListaTurmas().size());
    }

    @Test
    //novo professor
    public void testProfessorNome(){
        ca.cadastrarProfessores("Professor Teste", 109);
        assertEquals(ca.getProfessor("Professor Teste").getNome(), ca.getProfessor("Professor Teste").getNome());
    }

    @Test
    // mostrar professor pelo ID
    public void testProfessorId(){
        ca.cadastrarProfessores("Professor Teste", 109);
        assertEquals(ca.getProfessor("Professor Teste").getId(), ca.getProfessor("Professor Teste").getId());
    }

    @Test
    // mostrar professor pelo RDM
    public void testProfessorRdm(){
        ca.cadastrarProfessores("Professor Teste", 109);
        assertEquals(ca.getProfessor("Professor Teste").getRdm().getClass(), ca.getProfessor("Professor Teste").getRdm().getClass());
    }

    @Test
    //teste para professores diferentes
    public void testeProfessoresDiferentes(){
        assertNotEquals(ca.getProfessor("Fabio"), ca.getProfessor("Sabrina"));
    }

    @Test
    //teste para professora nao atribuida a nenhuma disciplina
    public void professorListaVazia(){
        assertNull(ca.getProfessor("Luciana").getRdm().mostrarDisciplinas());
    }

}