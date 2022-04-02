package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;

import sig.SIG;
import administrativo.Agenda;
import controleAcademico.exceptions.AlunoException;
import controleAcademico.exceptions.ProfessorException;
import controleAcademico.exceptions.TurmaException;
import infraEstrutura.exceptions.SalaException;

public class Teste {
    private static SIG sig;
    private static Agenda agenda;

    @BeforeAll
    public static void startUp() {
        sig = new SIG();
        agenda = new Agenda();
    }

    /*Teste para agendar Entrevista da diretoria, agenda uma Entrevista da Diretoria, falha ao
    agendar novamente no mesmo horario e depois vai checar se possui alguma entrevista agendada para aquele horario*/
    @Test
    public void testAgendarEntrevistaDaDiretoria() {
        assertTrue(agenda.agendarEntrevista(LocalDateTime.of(2022, 3, 9, 12, 0, 0)));
        assertFalse(agenda.agendarEntrevista(LocalDateTime.of(2022, 3, 9, 12, 0, 0)));
        assertTrue(agenda.getEntrevistas().contains(LocalDateTime.of(2022, 3, 9, 12, 0, 0)));
    }

    /*Teste para agendar Reunião da diretoria, agenda uma reunião da Diretoria,  falha ao
    agendar novamente no mesmo horario e depois vai checar se possui alguma reunião agendada para aquele horario*/
    @Test
    public void testAgendarReuniaoDaDiretoria() {
        assertTrue(agenda.agendarReuniao(LocalDateTime.of(2022, 3, 8, 11, 0, 0)));
        assertFalse(agenda.agendarReuniao(LocalDateTime.of(2022, 3, 8, 11, 0, 0)));
        assertTrue(agenda.getReunioes().contains(LocalDateTime.of(2022, 3, 8, 11, 0, 0)));
    }

    //Teste cadastrar dívida
    @Test
    public void testCadastrarDivida() {
        //credito para pagar as contas
        assertTrue(sig.getFinanceiro().cadastrarDivida("Pagar as contas", 0.00, 5000.00));
    }

    //Teste para cadastrar um funcionário
    @Test
    public void testCadastrarFuncionario() {
        assertTrue(sig.getFinanceiro().cadastrarFuncionario("Silvio Santos", 2000.00));
        assertFalse(sig.getFinanceiro().cadastrarFuncionario("Silvio Santos", 2000.00));
    }

    @Test
    public void testCadastrarFuncionario2() {
        assertTrue(sig.getFinanceiro().cadastrarFuncionario("Rodolfo", 3000.00));
        assertFalse(sig.getFinanceiro().cadastrarFuncionario("Rodolfo", 3000.00));
    }

    //Teste para cadastrar Professor
    @Test
    public void testCadastrarProfessor() throws ProfessorException {
        assertTrue(sig.getControleAcademico().cadastrarProfessores("Sabrina", 123, 5.0));
        assertTrue(sig.getControleAcademico().cadastrarProfessores("Fabio", 456, 5.0));
    }

    //Verificar se já existe um professor com esse nome
    @Test
    public void testCadastrarProfessorIgual() throws ProfessorException {
        assertTrue(sig.getControleAcademico().cadastrarProfessores("Paulo", 789, 2.0));
        assertEquals(sig.getControleAcademico().getProfessor("Paulo").getNome(), "Paulo");
    }

    //Teste para Cadastrar Turma
    @Test
    public void testCadastrarTurmas() throws TurmaException {
        assertTrue(sig.getControleAcademico().cadastrarTurma("Metodos Avançados de Programação", "Terça", "11:00"));
        assertTrue(sig.getControleAcademico().cadastrarTurma("Banco de Dados", "Terça", "7:00"));
    }

    //Verifica se já existe uma turma com esse nome
    @Test
    public void testCadastrarTurmasIgual() throws TurmaException {
        assertTrue(sig.getControleAcademico().cadastrarTurma("Redes", "Quarta", "11:00"));
        assertEquals(sig.getControleAcademico().buscarTurma("Redes").getDisciplina().getNome(), "Redes");
    }

    //Teste para Cadastrar Aluno
    @Test
    public void testCadastrarAluno() throws AlunoException {
        assertTrue(sig.getControleAcademico().adicionarAlunos("Jefferson", 1, "Computação"));
        assertTrue(sig.getControleAcademico().adicionarAlunos("Rafaela", 2, "Computação"));
    }

    //Verifica se já existe um aluno com esse nome
    @Test
    public void testCadastrarAlunoIgual() throws AlunoException {
        assertTrue(sig.getControleAcademico().adicionarAlunos("Aluno Teste", 3, "Computação"));
        assertEquals(sig.getControleAcademico().getAluno("Aluno Teste").getNome(), "Aluno Teste");
    }

    //Teste para materiais cadastrados
    @Test
    public void testMateriaisCadastro(){
        assertTrue(sig.getAlmoxarifado().cadastrarMaterial("Lápis", 2.00));
        assertTrue(sig.getAlmoxarifado().cadastrarMaterial("Cartolina", 33.95));
        assertTrue(sig.getAlmoxarifado().comprarMaterial("Computador", 3000.00));
    }

    //Teste para salas cadastradas
    @Test
    public void testSalas() throws TurmaException, SalaException {
        assertTrue(sig.getInfraEstrutura().cadastrarSala(101, "A - CCT", true));
        assertTrue(sig.getInfraEstrutura().cadastrarSala(103, "B - CCT", true));
        assertTrue(sig.getInfraEstrutura().cadastrarSala(104, "C - CCT", true));
    }

    //Teste cadastrar disciplina na sala e falso se tentar cadastrar a mesma disciplina
    @Test
    public void testSalaDisciplina() throws TurmaException, SalaException {
        sig.getControleAcademico().cadastrarTurma("Banco de Dados", "Terça", "7:00");
        assertTrue(sig.getInfraEstrutura().reservarSala(sig.getControleAcademico().buscarTurma("Banco de Dados"), 104, "C - CCT"));
        assertFalse(sig.getInfraEstrutura().reservarSala(sig.getControleAcademico().buscarTurma("Banco de Dados"), 104, "C - CCT"));
    }

    //Teste de salar disponiveis (sala C se encontra indisponivel)
    @Test
    public void testSalaDisponivel() throws TurmaException, SalaException {
        assertTrue(sig.getInfraEstrutura().getSala(101, "A - CCT").getDisponibilidade());
        assertTrue(sig.getInfraEstrutura().getSala(103, "B - CCT").getDisponibilidade());
        assertFalse(sig.getInfraEstrutura().getSala(104, "C - CCT").getDisponibilidade());
    }

    //Testes de exceção:
    @Test
    public void testProfessorException(){ //para professor não cadastrado
        assertThrows(ProfessorException.class, () -> {
            sig.getControleAcademico().getProfessor("Professor não existe");
        });
    }

    @Test
    public void testAlunoException(){  //para aluno não cadastrado
        assertThrows(AlunoException.class, () -> {
            sig.getControleAcademico().getAluno("Aluno não existe");
        });
    }

    @Test
    public void testTurmaException() { //para Professor não cadastrado na turma
        assertThrows(TurmaException.class, () -> {
            sig.getControleAcademico().definirProfessorNaDisciplina("Fabio", "Turma não existe");
        });
    }

    @Test
    public void testTurmaException2() { //Teste para turma não cadastrada
        assertThrows(TurmaException.class, () -> {
            sig.getControleAcademico().buscarTurma("Teste turma não existe");
        });
    }

    @Test
    public void testTurmaException3() { //para Aluno não cadastrado na turma
        assertThrows(TurmaException.class, () -> {
            sig.getControleAcademico().cadastrarAlunosNaDisciplina("Aluno Teste", "Turma não existe");

        });
    }
}
